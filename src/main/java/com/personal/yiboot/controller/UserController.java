package com.personal.yiboot.controller;

import com.personal.yiboot.bean.param.UserParam;
import com.personal.yiboot.bean.pojo.User;
import com.personal.yiboot.common.page.PageResult;
import com.personal.yiboot.service.UserService;
import com.personal.yiboot.tasks.AsyncLogTask;
import com.personal.yiboot.utils.LoggerUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/user")
@Api("用户相关")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AsyncLogTask asyncLogTask;

    private final static Logger logger = Logger.getLogger(UserController.class);//给类初始化日志对象
    @GetMapping("/userList")
    @ApiOperation(value="用户列表",notes = "分页查询")
    public PageResult<User> findUserList(UserParam param){
        LoggerUtil.info(logger,"pageSize={0},pageIndex={1}",param.getPageSize(),param.getPageIndex());
        PageResult<User> result = userService.findUserList(param);
        return result;
    }

    @PostMapping("/addUser")
    @ApiOperation(value="新增用户",notes = "新增")
    public int addUser(User user) throws Exception{
        int num = userService.addUser(user);
        Future<Boolean> add = asyncLogTask.insertLog(user);
        //（一定）没有输出 说明没有执行完异步任务
        while (add.isDone()){
            System.out.println("insertLog is done ");
        }
        return num;
    }
}
