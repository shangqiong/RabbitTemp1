package com.security_1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")  // 设置运行跨域的路径
                .allowedOriginPatterns("*")  // 是否运行跨域的域名
                .allowCredentials(true)  // 是否运行cookie
                .allowedMethods("GET", "POST", "DELET", "PUT")  // 设置允许的请求方式
                .allowedHeaders("*")  // 设置运行的header属性
                .maxAge(3600);  // 跨域运行时间
    }
}
