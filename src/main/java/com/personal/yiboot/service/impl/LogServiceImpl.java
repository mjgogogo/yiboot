package com.personal.yiboot.service.impl;

import com.personal.yiboot.bean.pojo.OperateLog;
import com.personal.yiboot.dao.OperateLogMapper;
import com.personal.yiboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public int addLog(OperateLog log) {
        return operateLogMapper.insertOperateLog(log);
    }
}
