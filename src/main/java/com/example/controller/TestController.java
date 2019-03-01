package com.example.controller;

import com.example.dto.PageView;
import com.example.dto.ResultDto;
import com.example.dto.UrlDto;
import com.example.dto.UserDto;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * TestController
 *
 * @author yezw1506
 * @date 2019-02-22
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Value("${url.baidu}")
    private String url;

    @Autowired
    private UserService userService;

    /**
     * 获取百度url
     * @return
     */
    @RequestMapping(value = "/url", method = RequestMethod.GET)
    public ResultDto test() {
        ResultDto<UrlDto> result = new ResultDto<>();
        UrlDto urlDto = UrlDto.builder()
                .url(url)
                .build();
        result.setDate(urlDto);
        return result;
    }

    /**
     * 根据id获取用户数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResultDto getUser(@RequestParam(name = "id") Integer id) {
        ResultDto<UserDto> result = new ResultDto<>();
        try {
            UserDto userDto = userService.getUserById(id);
            result.setDate(userDto);
            result.setSuccess(true);
        } catch (RuntimeException e) {
            e.printStackTrace();
            result.setMessage("获取用户数据异常");
        }
        return result;
    }

    /**
     * 更新用户信息
     * @param userDto
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultDto updateUser(@RequestBody UserDto userDto) {
        ResultDto result = new ResultDto();
        try {
            userService.updateUserById(userDto);
            result.setSuccess(true);
        } catch (RuntimeException e) {
            e.printStackTrace();
            result.setMessage(e.getMessage());
        }
        return result;
    }

    /**
     * 根源获取用户信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public ResultDto getUserList(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        ResultDto<PageView> result = new ResultDto<>();
        try {
            PageView<UserDto> pageView = userService.getUserList(pageNum, pageSize);
            result.setDate(pageView);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setMessage("获取用户信息失败");
        }
        return result;
    }

}
