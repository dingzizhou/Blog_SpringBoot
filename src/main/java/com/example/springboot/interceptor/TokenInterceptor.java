package com.example.springboot.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.springboot.model.Result;
import com.example.springboot.model.enums.ResultCodeEnum;
import com.example.springboot.utils.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String servletPath = request.getServletPath();
        if(!servletPath.startsWith("/admin")) return true;
        String token = request.getHeader("token");
        if(!TokenUtil.verify(token)){
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(Result.fail(ResultCodeEnum.NO_LOGIN)));
            return false;
        }
        return true;
    }

}
