package com.example.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.example.springboot.model.Category;
import com.example.springboot.model.Result;
import com.example.springboot.model.vo.CategoryCountVO;
import com.example.springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/categoryList")
    public Result<List<Category>> listCategory(){
        return categoryService.listCategory();
    }

    @GetMapping("/admin/categoryListCount")
    public Result<Integer> categoryListCount(){
        return null;
    }

    @GetMapping("/categoryList")
    public Result<Map<String,Object>> listCategoryCount(){
        return categoryService.listCategoryCount();
    }

}
