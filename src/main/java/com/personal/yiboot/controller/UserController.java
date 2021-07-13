package com.personal.yiboot.controller;

import com.personal.yiboot.bean.pojo.User;
import com.personal.yiboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userList")
    public String findUserList(){
        System.out.println("enter userList");
        List<User> userList = userService.findUserList();
        return "";
    }
}
