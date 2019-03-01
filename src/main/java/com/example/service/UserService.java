package com.example.service;

import com.example.dto.PageView;
import com.example.dto.UserDto;

/**
 * UserService
 *
 * @author yezw1506
 * @date 2019-02-26
 */
public interface UserService {

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    UserDto getUserById(Integer id);

    /**
     * 更新用户信息
     * @param userDto
     */
    void updateUserById(UserDto userDto);

    /**
     * 分页获取用户信息
     * @param pageNum 当前页
     * @param pageSize 每页的数量
     * @return
     */
    PageView<UserDto> getUserList(Integer pageNum, Integer pageSize);
}
