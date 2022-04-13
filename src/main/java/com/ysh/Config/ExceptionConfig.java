package com.ysh.Config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
public class ExceptionConfig {
    //BadCredentialsException
    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler(AccessDeniedException e){
        System.out.println("未知异常！原因是:"+e);
        return e.getMessage();
    }

}
