package com.example.springboot.controller.admin;

import com.alibaba.fastjson.JSON;
import com.example.springboot.entity.Result;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import com.example.springboot.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody User user,
                        HttpSession session, RedirectAttributes attributes){
        User user_find = userService.checkUser(user.getUsername(),user.getPassword());
        if(user_find!=null){
            user_find.setPassword(null);
            String token = TokenUtil.sign(user_find);
            Result result = new Result(true, 200, "登录成功", token);
            return JSON.toJSONString(result);
        }
        else{
            Result result = new Result(false,500,"账号或者密码错误",null);
            return JSON.toJSONString(result);
        }
    }
}
