package com.example.springboot.service;


import com.example.springboot.model.Result;
import com.example.springboot.model.Tag;
import com.example.springboot.model.vo.TagCountVO;

import java.util.List;
import java.util.Map;

public interface TagService {

    Result<List<Tag>> listTag();
    Result<Map<String,Object>> listTagCount();
}
