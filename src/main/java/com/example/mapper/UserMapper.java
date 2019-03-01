package com.example.mapper;

import com.example.entity.User;
import com.example.utils.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * UserMapper
 *
 * @author yezw1506
 * @date 2019-02-27
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id") Integer id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Update("update user set name=#{name}, age=#{age}, sex=#{sex} where id=#{id}")
    int updateUserById(User user);
}
