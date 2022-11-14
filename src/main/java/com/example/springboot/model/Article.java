package com.example.springboot.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
//    id
    private Integer id;
//    标题
    private String title;
//    封面
    private String cover;
//    内容
    private String content;
//    分类
    private Category category;
//    是否置顶
    private Integer isTop;
//    是否回收
    private Integer isRecycle;
//    创建时间
    private String createTime;
//    最后修改时间
    private String updateTime;
//    标签列表
    private List<Tag> tagList;
//    浏览量
    private Double view;
}

