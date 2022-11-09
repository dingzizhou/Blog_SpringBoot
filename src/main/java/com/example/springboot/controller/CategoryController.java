package com.example.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.example.springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/categoryList")
    public String listCategory(){
        return JSON.toJSONString(categoryService.listCategory());
    }

}