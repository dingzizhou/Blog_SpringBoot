package com.example.springboot.service.impl;

import com.example.springboot.dao.CategoryDao;
import com.example.springboot.entity.Category;
import com.example.springboot.entity.Result;
import com.example.springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Override
    public Result listCategory() {
        List<Category> categoryList = categoryDao.listCategory();
        Map<Object, Object> map = new HashMap<>();
        map.put("category",categoryList);
        return new Result(true,200,"success",map);
    }
}
