package com.example.springboot.service;

import com.example.springboot.entity.Article;
import com.example.springboot.entity.Condition;
import com.example.springboot.entity.Result;

public interface ArticleService {

    Result listArticle(Condition condition);

    Result getArticleById(int id);

    Result updateArticle(Article article);

    Result addArticle(Article article);

    Result updateIsTop(int id);
}
