package com.qf.mapper;

import com.qf.pojo.Permission;
import com.qf.pojo.User;
import com.qf.pojo.UserRoler;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findOne(User user);

    int add(User user);

    int addRoler(UserRoler ur);

    List<Permission> selectById(Integer id);

    User selectByName(String name);
    //查询所有用户
    List<User> infAllUser();
    //根据id修改用户
    void updateUserById(User user);
    //根据id查询用户
    User selectUserById(int id);
}
