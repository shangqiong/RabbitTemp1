package com.security_1.handler;

import com.alibaba.fastjson.JSON;
import com.security_1.respons.ResponsResult;
import com.security_1.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponsResult result = new ResponsResult(HttpStatus.UNAUTHORIZED.value(), "用户认证失败");
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
