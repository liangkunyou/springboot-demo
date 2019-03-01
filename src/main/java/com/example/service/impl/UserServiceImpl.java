package com.example.service.impl;

import com.example.dto.PageView;
import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.example.utils.BeanCopierUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * UserServiceImpl
 *
 * @author yezw1506
 * @date 2019-02-26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @Override
    public UserDto getUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user != null) {
            UserDto userDto = new UserDto();
            BeanCopierUtils.copyProperties(user, userDto);
            return userDto;
        }
        return null;
    }

    /**
     * 更新用户信息
     * @param userDto
     */
    @Override
    public void updateUserById(UserDto userDto) {
        User user = new User();
        BeanCopierUtils.copyProperties(userDto, user);
        int i = userMapper.updateUserById(user);
        if (i != 1) {
            throw new RuntimeException("更新失败");
        }
    }

    /**
     * 分页获取用户信息
     * @param pageNum 当前页
     * @param pageSize 获取条数
     * @return
     */
    @Override
    public PageView<UserDto> getUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectAll());

        List<UserDto> list = new ArrayList<>();
        pageInfo.getList().forEach(user -> {
            UserDto userDto = new UserDto();
            BeanCopierUtils.copyProperties(user, userDto);
            list.add(userDto);
        });

        PageView<UserDto> pageView = new PageView<>();
        pageView.setPageNum(pageInfo.getPageNum());
        pageView.setPageSize(pageInfo.getPageSize());
        pageView.setPages(pageInfo.getPages());
        pageView.setTotal(pageInfo.getTotal());
        pageView.setList(list);

        return pageView;
    }
}
