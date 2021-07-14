package com.personal.yiboot.dao;

import com.personal.yiboot.bean.param.UserParam;
import com.personal.yiboot.bean.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper{

    List<User> findUserList(UserParam userParam);
}