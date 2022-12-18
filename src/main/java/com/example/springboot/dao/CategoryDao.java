package com.example.springboot.dao;

import com.example.springboot.model.Category;
import com.example.springboot.model.vo.CategoryCountVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CategoryDao {
    List<Category> listCategory();

    List<CategoryCountVO> listCategoryCount();
}
