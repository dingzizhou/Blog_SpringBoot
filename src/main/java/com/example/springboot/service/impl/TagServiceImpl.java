package com.example.springboot.service.impl;

import com.example.springboot.dao.TagDao;
import com.example.springboot.entity.Result;
import com.example.springboot.entity.Tag;
import com.example.springboot.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public Result listTag() {
        Map<Object, Object> map = new HashMap<>();
        List<Tag> tagList = tagDao.listTag();
        map.put("tag",tagList);
        Result result = new Result(true,200,"success",map);
        return result;
    }
}
