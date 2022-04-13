package com.ysh.Mapper;


import com.ysh.Pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper {
        User findUser(String username);
        User findUserById(int id);
        int loginOut(int id);
        int loginInter(int id);
        int userInsert(User user);
        //创建用户时默认权限
        int updateUser(int id);
}
