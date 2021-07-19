package com.personal.yiboot.comsumer;

import com.yb.common.api.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenmj
 * @date 2021/7/18 12:46
 */
@RestController
@RequestMapping("/test")
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @RequestMapping("/sayHello")
    public String sayHello(String message){
        return helloService.sayHello(message);
    }

}
