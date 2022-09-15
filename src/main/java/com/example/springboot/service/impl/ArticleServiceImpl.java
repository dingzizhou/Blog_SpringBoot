package com.example.springboot.service.impl;

import com.example.springboot.dao.ArticleDao;
import com.example.springboot.entity.Condition;
import com.example.springboot.entity.Result;
import com.example.springboot.entity.Article;
import com.example.springboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public Result listArticle(Condition condition) {
        List<Article> articleList = articleDao.adminArticleList(condition);
        Map<Object, Object> map = new HashMap<>();
        map.put("articleList",articleList);
        int count = articleDao.ArticleListCount(condition);
        map.put("count",count);
        Result result = new Result(true,200,"success",map);
        return result;
    }
    @Override
    public Result getArticleById(int id) {
        Map<Object, Object> map = new HashMap<>();
        Article article = articleDao.getArticleById(id);
        map.put("article",article);
        Result result = new Result(true,200,"success",map);
        return result;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result updateArticle(Article article) {
        try {
            articleDao.updateArticle(article);
            articleDao.delArticleTag(article.getTitle(),null);
            articleDao.addArticleTag(article.getTitle(), article.getTagList());
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new Result(false,500,"error",null);
        }
        return new Result(true,200,"success",null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addArticle(Article article){
        try {
            articleDao.addArticle(article);
            articleDao.addArticleTag(article.getTitle(),article.getTagList());
        }
        catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new Result(false,500,"error",null);
        }
        return new Result(true,200,"success",null);
    }

    @Override
    public Result updateIsTop(int id) {
        if(articleDao.updateIsTop(id) == 1){
            return new Result(true,200,"success",null);
        }
        else{
            return new Result(false,500,"error",null);
        }
    }
}
