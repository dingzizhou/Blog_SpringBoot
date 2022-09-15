package com.example.springboot.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.springboot.entity.Result;
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
            this.writeErrorMsg(5000,"请登录",response);
            return false;
        }
        return true;
    }

    private void writeErrorMsg(Integer code,String msg,HttpServletResponse response) throws IOException {
        Result result = new Result(false,code,msg,null);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(result));
    }

}
