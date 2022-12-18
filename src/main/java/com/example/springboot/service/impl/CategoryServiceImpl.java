package com.example.springboot.service.impl;

import com.example.springboot.dao.CategoryDao;
import com.example.springboot.model.Category;
import com.example.springboot.model.Result;
import com.example.springboot.model.vo.CategoryCountVO;
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
    public Result<List<Category>> listCategory() {
        List<Category> categoryList = categoryDao.listCategory();
        return Result.ok(categoryList);
    }

    @Override
    public Result<Map<String,Object>> listCategoryCount() {
        Map<String,Object> map = new HashMap<>();
        List<CategoryCountVO> categoryCountVOList = categoryDao.listCategoryCount();
        Integer count = categoryCountVOList.size();
        map.put("categoryList",categoryCountVOList);
        map.put("count",count);
        return Result.ok(map);
    }
}
