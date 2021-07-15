package com.personal.yiboot.dao;

import com.personal.yiboot.bean.pojo.OperateLog;
import org.springframework.stereotype.Repository;

@Repository
public interface OperateLogMapper {

    int insertOperateLog(OperateLog log);
}
