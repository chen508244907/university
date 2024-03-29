package com.qf.service;

import com.qf.pojo.*;

import java.util.List;

public interface UserService {
    User findOne(User user);

    int add(User user);

    int addRoler(UserRoler ur);

    List<Permission> selectById(Integer id);

    User selectByName(String name);
    //查询所有用户
    Msg infAllUser(Integer size, Integer page);
    //根据id修改用户
    void updateUserById(User user);
    //根据id查询用户
    User selectUserById(int id);
    //根据id删除用户
    void deleteById(int id);
    //删除中间
    void deletezjbById(int id);

    UserRoler selectRoler(Integer id);//查看用户权限

    int updateUserRoler(Integer uid);//修改用户权限

    UserMsg findUr(Integer id);

    int edit(User user);
}
