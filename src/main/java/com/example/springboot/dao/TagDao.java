package com.example.springboot.dao;


import com.example.springboot.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagDao {

    public List<Tag> listTag();
}
