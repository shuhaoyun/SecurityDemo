package com.ysh.handle;

import com.alibaba.fastjson.JSON;
import com.ysh.Utils.ResultUtil;
import com.ysh.Utils.webUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component()
@Slf4j
public class entryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //Full authentication is required to access this resource

        ResultUtil fial;
        String message = authException.getMessage();
        if(!message.isEmpty()){
            if(message.equals("Full authentication is required to access this resource")){
                fial = ResultUtil.fail("请重新登录", HttpStatus.UNAUTHORIZED.toString());
            }else {
                fial = ResultUtil.fail(message, HttpStatus.UNAUTHORIZED.toString());
            }

        }else{
            fial = ResultUtil.fail("认证失败", HttpStatus.UNAUTHORIZED.toString());
        }
        String s = JSON.toJSONString(fial);
        webUtil.rendString(response,s);



        //        ResultUtil fial;
//        Throwable t = (Throwable)request.getAttribute("javax.servlet.error.exception");
//        String message = authException.getMessage();
//        if(t!=null){
//                fial = ResultUtil.fail(t.getMessage(), HttpStatus.UNAUTHORIZED.toString());
//        }else if(!message.isEmpty()){
//            fial = ResultUtil.fail(message, HttpStatus.UNAUTHORIZED.toString());
//        }else{
//            fial = ResultUtil.fail("认证失败", HttpStatus.UNAUTHORIZED.toString());
//        }
//        String s = JSON.toJSONString(fial);
//        webUtil.rendString(response,s);

    }
}
