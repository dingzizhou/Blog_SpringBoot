package com.example.springboot.entity;
import com.example.springboot.entity.Tag;

import java.util.List;
public class Article {
    //    id
    private Integer id;
//    标题
    private String title;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsRecycle() {
        return isRecycle;
    }

    public void setIsRecycle(Integer isRecycle) {
        this.isRecycle = isRecycle;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", isTop=" + isTop +
                ", isRecycle=" + isRecycle +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", tagList=" + tagList +
                '}';
    }
}

