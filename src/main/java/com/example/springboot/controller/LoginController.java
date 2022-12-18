package com.example.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.example.springboot.model.Result;
import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import com.example.springboot.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody User user,
                        HttpSession session, RedirectAttributes attributes){
        User user_find = userService.checkUser(user.getUsername(),user.getPassword());
        if(user_find!=null){
            user_find.setPassword(null);
            String token = TokenUtil.sign(user_find);
            Result<String> result = new Result<String>(200, "登录成功", token);
            return result;
        }
        else{
            return Result.fail();
        }
    }
}
