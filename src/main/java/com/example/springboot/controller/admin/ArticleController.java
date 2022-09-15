package com.example.springboot.controller.admin;

import com.alibaba.fastjson2.JSON;
import com.example.springboot.entity.Article;
import com.example.springboot.entity.Condition;
import com.example.springboot.entity.Result;
import com.example.springboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/admin/articleList")
    public String AdminArticleList(Condition condition){
        return JSON.toJSONString(articleService.listArticle(condition));
    }

    @GetMapping("/admin/articleId")
    public String getArticleById(int id){
        return JSON.toJSONString(articleService.getArticleById(id));
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
}
