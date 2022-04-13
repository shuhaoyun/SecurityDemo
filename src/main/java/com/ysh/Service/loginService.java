package com.ysh.Service;

import com.ysh.Pojo.User;
import com.ysh.Utils.ResultUtil;

public interface loginService {
    ResultUtil queryLogin(User user);
    ResultUtil loginOut();
    ResultUtil userInsert(User user);
}
