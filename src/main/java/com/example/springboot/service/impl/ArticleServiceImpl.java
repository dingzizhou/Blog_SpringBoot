package com.example.springboot.service.impl;

import com.example.springboot.dao.ArticleDao;
import com.example.springboot.model.Condition;
import com.example.springboot.model.PageResult;
import com.example.springboot.model.Result;
import com.example.springboot.model.Article;
import com.example.springboot.model.dto.ArticleView;
import com.example.springboot.model.enums.ResultCodeEnum;
import com.example.springboot.service.ArticleService;
import com.example.springboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private HttpSession httpSession;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private RedisService redisService;

    @Override
    public PageResult<Article> listArticle(Condition condition) {
        Integer count = articleDao.articleListCount(condition);
        if(count == 0){
            return new PageResult<>();
        }
        List<Article> articleList = articleDao.articleList(condition);
        return new PageResult<>(articleList,count);
    }

    @Override
    public Article getArticleById(Integer id) {
        updateViewCount(id);
//        saveViewList();
        Article article = articleDao.getArticleById(id);
//        System.out.println("View:"+redisService.zScore("ArticleViewList",id.toString()));
        article.setView(redisService.zScore("ArticleViewList",id.toString()));
        return article;
    }
    @Override
    public Article getArticleById_Admin(Integer id){
        return articleDao.getArticleById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<String> updateArticle(Article article) {
        try {
            articleDao.updateArticle(article);
            articleDao.delArticleTag(article.getId(),null);
            if(article.getTagList().size() != 0) articleDao.addArticleTag(article.getId(), article.getTagList());
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new Result<>(ResultCodeEnum.FAIL.getCode(), ResultCodeEnum.FAIL.getDescribe(), null);
        }
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(),ResultCodeEnum.SUCCESS.getDescribe(),null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<String> addArticle(Article article){
        try {
            articleDao.addArticle(article);
            articleDao.addArticleTag(article.getId(),article.getTagList());
        }
        catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.fail(null);
        }
        return Result.ok(null);
    }

    @Override
    public Result<Object> updateIsTop(Integer id) {
        if(articleDao.updateIsTop(id) == 1){
            return Result.ok(null);
        }
        else{
            return Result.fail();
        }
    }

    @Override
    public List<ArticleView> getViewList(){
        return articleDao.getArticleView();
    }
    @Override
    public void saveViewList(){
        Map<Object, Double> map = redisService.zAllScore("ArticleViewList");
        List<ArticleView> list = new ArrayList<>();
        for(Object key:map.keySet() ) {
           list.add(new ArticleView((String) key, map.get(key)));
        }
        articleDao.saveArticleView(list);
    }

    @Override
    public void updateViewCount(Integer id){
//        System.out.println("获取到session："+httpServletRequest.getSession().toString());
//        String session = httpServletRequest.getSession().toString();
//        if(session != null){
//            if(redisService.hyperGet(session)==0){
//                redisService.hyperAdd("Viewed",session);
//                redisService.hIncr("ArticleViewList",id.toString(), 1L);
//            }
//        }
        redisService.zIncr("ArticleViewList",id.toString(), 1D);
    }
}
