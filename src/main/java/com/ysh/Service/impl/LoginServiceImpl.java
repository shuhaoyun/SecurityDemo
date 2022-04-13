package com.ysh.Service.impl;

import com.ysh.Mapper.userMapper;
import com.ysh.Pojo.User;
import com.ysh.Service.loginService;
import com.ysh.Utils.JwtUtils;
import com.ysh.Utils.ResultUtil;
import com.ysh.Utils.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements loginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private userMapper userMapper1;

    @Override
    public ResultUtil queryLogin(User user) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authentication);
        UserDetail userDetail = (UserDetail) authenticate.getPrincipal();
        Integer id = userDetail.getUser().getId();
        if(userDetail.getUser().getStatu()!=1){
            userMapper1.loginInter(id);
        }
        String token = JwtUtils.createJWT(id.toString());
        Map<String,String> map=new HashMap<String,String>();
        map.put("token",token);
        System.out.println("queryLoginservice");
        return ResultUtil.succ("登录成功",map);
    }

    @Override
    public ResultUtil loginOut() {
        UserDetail userDtil = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userMapper1.loginOut(userDtil.getUser().getId());
        return ResultUtil.succ("退出成功",null);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    //插入用户
    @Override
    @Transactional
    public ResultUtil userInsert(User user) {

        User ysh = userMapper1.findUser(user.getUsername());
        if(ysh!=null){
            return ResultUtil.fail("已存在此用户");
        }
        //密码加密
        String pass=passwordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        int i = userMapper1.userInsert(user);

        if(i==1){
            User user1 = userMapper1.findUser(user.getUsername());
            int i1 = userMapper1.updateUser(user1.getId());
            if(i1==1){
                return ResultUtil.succ("注册成功",null);
            }
        }
        return ResultUtil.fail("注册失败");
    }
}
