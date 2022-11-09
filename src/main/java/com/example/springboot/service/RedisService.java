package com.example.springboot.service;

import org.springframework.stereotype.Service;

public interface RedisService {

    void set(String key,Object value);
    Object get(String key);
    Boolean del(String key);

}
