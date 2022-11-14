package com.example.springboot.service;

import com.example.springboot.model.Article;
import com.example.springboot.model.Condition;
import com.example.springboot.model.PageResult;
import com.example.springboot.model.Result;
import com.example.springboot.model.dto.ArticleView;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    PageResult<Article> listArticle(Condition condition);

    Article getArticleById(Integer id);
    Article getArticleById_Admin(Integer id);

    Result updateArticle(Article article);

    Result addArticle(Article article);

    Result updateIsTop(Integer id);

    List<ArticleView> getViewList();
    void saveViewList();
    void updateViewCount(Integer id);
}
