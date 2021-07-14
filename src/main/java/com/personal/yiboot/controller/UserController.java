package com.personal.yiboot.controller;

import com.personal.yiboot.bean.param.UserParam;
import com.personal.yiboot.bean.pojo.User;
import com.personal.yiboot.common.page.PageResult;
import com.personal.yiboot.service.UserService;
import com.personal.yiboot.utils.LoggerUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
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
    private final static Logger logger = Logger.getLogger(UserController.class);//给类初始化日志对象
    @GetMapping("/userList")
    @ApiOperation(value="用户列表",notes = "分页查询")
    public PageResult<User> findUserList(UserParam param){
        LoggerUtil.info(logger,"pageSize()={0},pageIndex={1}",param.getPageSize(),param.getPageIndex());
        PageResult<User> result = userService.findUserList(param);
        return result;
    }
}
