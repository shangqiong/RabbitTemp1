package com.security_1;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.security_1.dao.LoginUser;
import com.security_1.dao.User;
import com.security_1.mapper.RightMapper;
import com.security_1.mapper.UserMapper;
import com.security_1.utils.JwtUtil;
import com.security_1.utils.RedisCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import static com.security_1.utils.JwtUtil.*;
import java.util.List;
import static com.security_1.dao.LoginUser.*;

@SpringBootTest
class Security1ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private RightMapper rightMapper;
    @Test
    void contextLoads() throws Exception {
        List<String> rightsById = rightMapper.getRightsById(1L);
        for (String s : rightsById) {
            System.out.println(s);
        }
    }

}
