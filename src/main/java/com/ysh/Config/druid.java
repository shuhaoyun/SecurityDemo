package com.ysh.Config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class druid {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid111(){
        return new DruidDataSource();
    }
    //后台监控
    @Bean
    public ServletRegistrationBean ServletRegistrationBean(){
        ServletRegistrationBean<StatViewServlet> statView = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台需要有人登录,账号密码配置
        HashMap<String, String> init = new HashMap<>();
        //增加配置
        init.put("loginUsername","admin");//key是固定的
        init.put("loginPassword","123456");
        //允许谁访问
        init.put("allow","");
        //init.put("123","iddress");//禁止访问后加ip地址

        statView.setInitParameters(init);
        return statView;
    }
}
