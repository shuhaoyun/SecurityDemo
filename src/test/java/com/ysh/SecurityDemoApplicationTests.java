package com.ysh;

import com.ysh.Mapper.userMapper;
import com.ysh.Pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SecurityDemoApplicationTests {
    @Autowired
    private com.ysh.Mapper.userMapper userMapper;
    @Test
    void contextLoads() {
        User ysh = userMapper.findUser("ysh11");

        System.out.println(ysh);
    }
    @Test
    void testgetName(){
        User ysh = userMapper.findUser("ysh");
        System.out.println(ysh);
    }
    @Test
    void insrt(){
        User user1 = new User();
        user1.setUsername("123456");
        user1.setPassword("a123456");
        int i = userMapper.userInsert(user1);
        System.out.println(i);
    }
    @Autowired
    //@Qualifier("enen")
    PasswordEncoder passwordEncoder;
    @Test
    void encode(){
        System.out.println(passwordEncoder.encode("1234"));
    }

}
