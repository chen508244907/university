package com.qf.mapper;

import com.qf.pojo.Permission;
import com.qf.pojo.User;
import com.qf.pojo.UserMsg;
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
    //根据id删除用户
    void deleteById(int id);
    //删除中间
    void deletezjbById(int id);

    UserRoler selectRoler(Integer id);//根据用户id查找相关权限

    int updateUserRoler(Integer uid);//根据用户id修改权限

    UserMsg findUr(Integer id);//根据用户id查询用户相关信息

    int edit(User user);
}
