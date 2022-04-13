package com.ysh.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class springMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //允许跨域请求的域名
                .allowedOriginPatterns("*")
                //是否允许cookie
                .allowCredentials(true)
                //设置允许的请求方式
                .allowedMethods("get","post","put","delete")
                //设置允许的header属性
                .allowedHeaders("*")
                //允许跨域时间
                .maxAge(3600);
    }
}
