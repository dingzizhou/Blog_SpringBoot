package com.example.springboot.dao;

import com.example.springboot.entity.Condition;
import com.example.springboot.entity.Article;
import com.example.springboot.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleDao {

//    后台查询文章
    List<Article> adminArticleList(@Param("condition") Condition condition);
//    后台文章数量查询
    Integer ArticleListCount(@Param("condition") Condition condition);
//    根据Id获取文章
    Article getArticleById(@Param("id") int id);
//    更改是否置顶
    Integer updateIsTop(@Param("id") int id);
//    更新文章表
    Integer updateArticle(@Param("article") Article article);
//    向文章表添加文章
    Integer addArticle(@Param("article") Article article);
//    文章-标签表删除
    Integer delArticleTag(@Param("article")String article,@Param("tag")String tag);
//    文章-标签表添加
    Integer addArticleTag(@Param("title")String title,@Param("tagList") List<Tag> tagList);

}
