package com.example.springboot.controller.admin;


import com.alibaba.fastjson.JSON;
import com.example.springboot.entity.Result;
import com.example.springboot.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("tagList")
    public String listTag(){
        Result result = tagService.listTag();
        return JSON.toJSONString(result);
    }
}
