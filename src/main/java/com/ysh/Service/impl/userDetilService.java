package com.ysh.Service.impl;


import com.ysh.Mapper.userMapper;
import com.ysh.Pojo.User;
import com.ysh.Utils.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class userDetilService implements UserDetailsService {


    @Autowired
    private userMapper userMapper1;

    //@Bean
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper1.findUser(username);
        if(user==null){
            throw new RuntimeException("用户名错误");
        }
        UserDetail userDetail = new UserDetail();
        userDetail.setUser(user);
        log.info("获取的userDetail"+userDetail);
        return userDetail;
    }
}
