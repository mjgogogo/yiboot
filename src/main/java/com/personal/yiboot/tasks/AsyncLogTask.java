package com.personal.yiboot.tasks;

import com.personal.yiboot.bean.pojo.OperateLog;
import com.personal.yiboot.bean.pojo.User;
import com.personal.yiboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncLogTask {

    @Autowired
    private LogService logService;

    @Async
    public <T> Future<Boolean> insertLog(T obj) throws Exception{
        long start = System.currentTimeMillis();
        OperateLog log = new OperateLog();
        log.setOperateType("insert");
        if (obj instanceof User){
            //生成用户信息str
            User user = (User)obj;
            StringBuilder sb = new StringBuilder();
            sb.append("用户名：").append(user.getName()).append(",密码：").append(user.getPassword());
            log.setDetail(sb.toString());
        }
        //异步插入日志表
        logService.addLog(log);
        long end  = System.currentTimeMillis();
        System.out.println("任务耗时："+ (end-start)+"毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public <T> Future<Boolean> updateLog(T obj) throws Exception{
        long start = System.currentTimeMillis();
        Thread.sleep(900);
        long end  = System.currentTimeMillis();
        System.out.println("任务耗时："+ (end-start)+"毫秒");
        return new AsyncResult<>(true);
    }


}
