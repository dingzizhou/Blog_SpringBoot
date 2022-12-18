package com.example.springboot.service;

import com.example.springboot.model.Category;
import com.example.springboot.model.Result;
import com.example.springboot.model.vo.CategoryCountVO;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    Result<List<Category>> listCategory();
    Result<Map<String,Object>> listCategoryCount();
}
