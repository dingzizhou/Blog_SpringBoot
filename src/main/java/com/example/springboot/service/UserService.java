package com.example.springboot.service;

import com.example.springboot.entity.User;

public interface UserService {

    //登录核对用户名和密码
    User checkUser(String username,String password);

}
