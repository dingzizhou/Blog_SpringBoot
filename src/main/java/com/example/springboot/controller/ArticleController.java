package com.example.springboot.controller;

import com.alibaba.fastjson2.JSON;
import com.example.springboot.model.Article;
import com.example.springboot.model.Condition;
import com.example.springboot.model.PageResult;
import com.example.springboot.model.Result;
import com.example.springboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/admin/articleList")
    public Result<PageResult<Article>> adminArticleList(Condition condition){
        return Result.ok(articleService.listArticle(condition));
    }

    @GetMapping("/home/articleList")
    public Result<PageResult<Article>> homeArticleList(Condition condition){
        return Result.ok(articleService.listArticle(condition));
    }

    @GetMapping("/admin/articleId")
    public Result<Article> getArticleById(int id){
        return Result.ok(articleService.getArticleById(id));
    }

    @PostMapping("/admin/updateArticle")
    public String updateArticle(@RequestBody Article article){
        return JSON.toJSONString(articleService.updateArticle(article));
    }

    @PostMapping("/admin/addArticle")
    public String addArticle(@RequestBody Article article){
        return JSON.toJSONString(articleService.addArticle(article));
    }

    @PostMapping("/admin/article/changeIsTop")
    public String updateIsTop(Integer id){
        return JSON.toJSONString(articleService.updateIsTop(id));
    }

    @GetMapping("/article/{articleId}")
    public Result<Article> getArticleById(@PathVariable("articleId") Integer articleId){
        return Result.ok(articleService.getArticleById(articleId));
    }

}
