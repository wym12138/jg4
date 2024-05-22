package com.ym.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.hasText(token)){
            throw new RuntimeException("未登录，请登陆后重试");
        }else {
            try {
                Claims claims = JwtUtil.parseJWT(token);
                String subject = claims.getSubject();
                System.out.println(subject);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("未登录，请登陆后重试");
            }
        }
        return true;
    }
}
