package com.example.springboot.service.impl;

import com.example.springboot.dao.ArticleDao;
import com.example.springboot.model.Condition;
import com.example.springboot.model.PageResult;
import com.example.springboot.model.Result;
import com.example.springboot.model.Article;
import com.example.springboot.service.ArticleService;
import com.example.springboot.service.RedisService;
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
    public Article getArticleById(int id) {
        return articleDao.getArticleById(id);
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
