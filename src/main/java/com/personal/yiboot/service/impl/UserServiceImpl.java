package com.personal.yiboot.service.impl;

import com.github.pagehelper.Page;
import com.personal.yiboot.bean.param.UserParam;
import com.personal.yiboot.bean.pojo.User;
import com.personal.yiboot.common.page.PageResult;
import com.personal.yiboot.dao.UserMapper;
import com.personal.yiboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageResult<User> findUserList(UserParam param){
        //分页
        //PageHelper.startPage(1,10);// 参数里面有分页信息，这里可以去掉
        Page<User> page = (Page)userMapper.findUserList(param);
        return new PageResult(page.getResult(),page.getTotal(),page.getPageNum(),page.getPageSize(), page.getPages());
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }
}
