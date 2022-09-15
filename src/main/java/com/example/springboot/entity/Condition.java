package com.example.springboot.entity;

public class Condition {
    private Integer current;
    private Integer size;
    private String keywords;
    private Integer categoryId;
    private Integer tagId;
    private Integer isTop;
    private Integer isRecycler;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsRecycler() {
        return isRecycler;
    }

    public void setIsRecycler(Integer isRecycler) {
        this.isRecycler = isRecycler;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "current=" + current +
                ", size=" + size +
                ", keywords='" + keywords + '\'' +
                ", categoryId=" + categoryId +
                ", tagId=" + tagId +
                ", isTop=" + isTop +
                ", isRecycler=" + isRecycler +
                '}';
    }
}
