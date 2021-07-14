package com.personal.yiboot.controller;

import com.personal.yiboot.bean.param.UserParam;
import com.personal.yiboot.bean.pojo.User;
import com.personal.yiboot.common.page.PageResult;
import com.personal.yiboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userList")
    public PageResult<User> findUserList(){
        System.out.println("enter userList");
        UserParam param = new UserParam();
        PageResult<User> result = userService.findUserList(param);
        return result;
    }
}
