package com.example.springboot.controller;


import com.alibaba.fastjson.JSON;
import com.example.springboot.model.Result;
import com.example.springboot.model.Tag;
import com.example.springboot.model.vo.TagCountVO;
import com.example.springboot.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/admin/tagList")
    public Result<List<Tag>> listTag(){
        return tagService.listTag();
    }

    @GetMapping({ "tagList"})
    public Result<Map<String,Object>> listTagCount(){
        return tagService.listTagCount();
    }
}
