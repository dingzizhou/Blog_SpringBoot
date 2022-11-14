package com.example.springboot.handler;

import com.example.springboot.dao.ArticleDao;
import com.example.springboot.model.dto.ArticleView;
import com.example.springboot.service.ArticleService;
import com.example.springboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
public class InitHandler {

    @Autowired
    private RedisService redisService;
    @Autowired
    private ArticleService articleService;

    @PostConstruct
    public void init() throws Exception{
        System.out.println("Redis初始化");
        List<ArticleView> list = articleService.getViewList();
//        Map<String,Object> map =
//        new HashMap<>();
        for (ArticleView i:list) {
            redisService.zAdd("ArticleViewList", i.getId(), i.getView());
//            map.put(i.getId(),i.getView());
        }
//        System.out.println(redisService.zScore("ArticleViewList",list.get(9).getId()));
//        System.out.println(map.toString());
//        redisService.hSetAll("ArticleViewList",map);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("保存Redis数据");
        articleService.saveViewList();
        redisService.del("ArticleViewList");
    }
}
