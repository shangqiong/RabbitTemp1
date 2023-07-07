package com.security_1.service.impl;

import com.security_1.dao.LoginUser;
import com.security_1.dao.User;
import com.security_1.respons.ResponsResult;
import com.security_1.service.LoginService;
import com.security_1.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import com.security_1.utils.RedisCache;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponsResult login(User user) {
        System.out.println("登录2");
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        System.out.println("登录3");
        if(Objects.isNull(authenticate)) throw new RuntimeException("登录失败");
        LoginUser loginUser = (LoginUser)authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        Map<String , String > map = new HashMap<>();
        map.put("token", JwtUtil.createJWT(userid));
        redisCache.setCacheObject("login:" + userid, loginUser);
        System.out.println(loginUser);
        System.out.println("登录成功");
        return new ResponsResult(200, "登录成功", map);
    }

    @Override
    public ResponsResult logout() {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long id = loginUser.getUser().getId();
        redisCache.deleteObject("login:"+id);
        return new ResponsResult(200, "退出登录");
    }
}
