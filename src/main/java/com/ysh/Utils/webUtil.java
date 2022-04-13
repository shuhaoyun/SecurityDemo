package com.ysh.Utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class webUtil{
    public static String rendString(HttpServletResponse res,String string)   {
        log.info("进入异常返回页"+string);
        try {
            res.setStatus(200);
            res.setContentType("application/json");
            res.setCharacterEncoding("utf-8");
            res.getWriter().print(string);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
