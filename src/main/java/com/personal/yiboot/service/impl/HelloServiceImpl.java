package com.personal.yiboot.service.impl;

import com.personal.yiboot.common.api.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author chenmj
 * @date 2021/7/16 20:07
 */
@Service
public class HelloServiceImpl implements UserInfoService {

    @Override
    public String sayHello(String message) {
        return "Hello" + message;
    }
}
