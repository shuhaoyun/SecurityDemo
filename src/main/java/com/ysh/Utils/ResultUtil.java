package com.ysh.Utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultUtil{
    //public class Result implements Serializable {
    private String code;
    private String msg;
    private Object data;
    public static ResultUtil succ(Object data) {
        ResultUtil m = new ResultUtil();
        m.setCode("0");
        m.setData(data);
        m.setMsg("操作成功");
        return m;
    }
    public static ResultUtil succ(String mess, Object data) {
        ResultUtil m = new ResultUtil();
        m.setCode("0");
        m.setData(data);
        m.setMsg(mess);
        return m;
    }
    public static ResultUtil fail(String mess) {
        ResultUtil m = new ResultUtil();
        m.setCode("-1");
        m.setData(null);
        m.setMsg(mess);
        return m;
    }
    public static ResultUtil fail(String mess, Object data) {
        ResultUtil m = new ResultUtil();
        m.setCode("-1");
        m.setData(data);
        m.setMsg(mess);
        return m;
    }public static ResultUtil fail(String mess, String code) {
        ResultUtil m = new ResultUtil();
        m.setCode(code);
        m.setData(null);
        m.setMsg(mess);
        return m;
    }
    public static ResultUtil fail(String mess, String code,Object obj) {
        ResultUtil m = new ResultUtil();
        m.setCode(code);
        m.setData(obj);
        m.setMsg(mess);
        return m;
    }


}
