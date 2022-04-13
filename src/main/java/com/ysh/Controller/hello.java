package com.ysh.Controller;

import com.ysh.Pojo.User;
import com.ysh.Utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "测试接口", tags = "测序接口")
public class hello {
    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('select')")
    @ApiImplicitParam(name = "测试hello", value = "hello")
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "测试", notes = "返回你好所需权限为select")
    public ResultUtil hello(){
        return ResultUtil.succ("你好",null);
    }

    @GetMapping("/hello1")
    @PreAuthorize("hasAuthority('upadta')")
    @ApiImplicitParam(name = "测试", value = "hello1")
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "测试", notes = "返回你好所需权限为updata")
    public ResultUtil upddd(){
        return ResultUtil.succ("你好",null);
    }

}
