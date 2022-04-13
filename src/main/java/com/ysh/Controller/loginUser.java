package com.ysh.Controller;


import com.ysh.Pojo.User;
import com.ysh.Service.loginService;
import com.ysh.Utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
//@Api(value = "测试接口", tags = "用户管理相关的接口", description = "用户测试接口")
@Api(value = "登录接口", tags = "登录相关的接口")
public class loginUser {
    @Autowired
    private loginService loginService;
    @ApiImplicitParam(name = "登录", value = "登录用户数据")
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "登录", notes = "登录获取token")
    @PostMapping("/login")
    public ResultUtil login(@RequestBody @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            Map<String, String> map = new HashMap<>();
            bindingResult.getFieldErrors().forEach((item) -> {
                String msg = item.getDefaultMessage();
                String fie = item.getField();
                map.put(fie, msg);
            });
            return ResultUtil.fail("验证",map.toString());
        }
        ResultUtil resultUtil = loginService.queryLogin(user);
        System.out.println("controller");
        return resultUtil;
    }
    //方法参数说明，name参数名；value参数说明，备注；dataType参数类型；required 是否必传；defaultValue 默认值
    @ApiImplicitParam(name = "token", value = "携带token进行退出")
//    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "退出", notes = "退出")
    @PutMapping("/loginOut")
    public ResultUtil logOut(){

        return loginService.loginOut();
    }
    @ApiImplicitParam(name = "注册", value = "新增账户携带用户名密码")
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "添加用户", notes = "添加用户")
    @PostMapping("/insert")
    public ResultUtil insert(@RequestBody @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            Map<String, String> map = new HashMap<>();
            bindingResult.getFieldErrors().forEach((item) -> {
                String msg = item.getDefaultMessage();
                String fie = item.getField();
                map.put(fie, msg);
            });
            return ResultUtil.fail("输入有误","406",map.toString());
        }
        return loginService.userInsert(user);
    }
}
