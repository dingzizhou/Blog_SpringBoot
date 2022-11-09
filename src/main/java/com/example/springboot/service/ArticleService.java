package com.example.springboot.service;

import com.example.springboot.model.Article;
import com.example.springboot.model.Condition;
import com.example.springboot.model.PageResult;
import com.example.springboot.model.Result;

public interface ArticleService {

    PageResult<Article> listArticle(Condition condition);

    Article getArticleById(int id);

    Result updateArticle(Article article);

    Result addArticle(Article article);

    Result updateIsTop(int id);
}
