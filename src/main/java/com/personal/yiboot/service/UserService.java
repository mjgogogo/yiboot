package com.personal.yiboot.service;

import com.personal.yiboot.bean.param.UserParam;
import com.personal.yiboot.bean.pojo.User;
import com.personal.yiboot.common.page.PageResult;


public interface UserService {

    PageResult<User> findUserList(UserParam param);

}
