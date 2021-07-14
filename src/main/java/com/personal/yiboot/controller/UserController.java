package com.personal.yiboot.controller;

import com.personal.yiboot.bean.param.UserParam;
import com.personal.yiboot.bean.pojo.User;
import com.personal.yiboot.common.page.PageResult;
import com.personal.yiboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api("用户相关")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    @ApiOperation(value="用户列表",notes = "分页查询")
    public PageResult<User> findUserList(UserParam param){
        System.out.println("enter userList");
        PageResult<User> result = userService.findUserList(param);
        return result;
    }
}
