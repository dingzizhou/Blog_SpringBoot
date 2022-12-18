package com.example.springboot.service.impl;

import com.example.springboot.dao.TagDao;
import com.example.springboot.model.Result;
import com.example.springboot.model.Tag;
import com.example.springboot.model.vo.TagCountVO;
import com.example.springboot.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public Result<List<Tag>> listTag() {
        List<Tag> tagList = tagDao.listTag();
        return Result.ok(tagList);
    }

    @Override
    public Result<Map<String,Object>> listTagCount() {
        Map<String,Object> map = new HashMap<>();
        List<TagCountVO> tagCountVOList = tagDao.listTagCountList();
        Integer count = tagCountVOList.size();
        map.put("tagList",tagCountVOList);
        map.put("count",count);
        return Result.ok(map);
    }
}
