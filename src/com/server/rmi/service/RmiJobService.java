package com.server.rmi.service;

import com.web.job.Job;
import com.web.job.Result;

/**
 * 任务接口
 * @author linys
 * @version 2014-9-1
 * @category service
 */
public interface RmiJobService {
    /**
     * 获取任务接口
     * @return
     */
    Job getJob();
    /**
     * 保存任务执行结果
     */
    void saveJobResult(Result result);
}
