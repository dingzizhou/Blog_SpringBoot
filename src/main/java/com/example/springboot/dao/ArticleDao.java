package com.example.springboot.dao;

import com.example.springboot.model.Condition;
import com.example.springboot.model.Article;
import com.example.springboot.model.Tag;
import com.example.springboot.model.dto.ArticleView;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ArticleDao {

    List<Article> articleList(@Param("condition") Condition condition);
    Integer articleListCount(@Param("condition") Condition condition);

//    根据Id获取文章
    Article getArticleById(@Param("id") int id);
//    更改是否置顶
    Integer updateIsTop(@Param("id") int id);
//    更新文章表
    void updateArticle(@Param("article") Article article);
//    向文章表添加文章
    void addArticle(@Param("article") Article article);
//    文章-标签表删除
    void delArticleTag(@Param("article")String article,@Param("tag")String tag);
//    文章-标签表添加
    void addArticleTag(@Param("title")String title,@Param("tagList") List<Tag> tagList);
//    获取浏览量列表

    List<ArticleView> getArticleView();
//    保存浏览量列表
    void saveArticleView(@Param("viewList")List<ArticleView> viewList);
}
