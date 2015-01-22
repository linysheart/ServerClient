package com.web.job;

import java.io.Serializable;

/**
 * 工作任务
 * @author zhengzl
 * @since 2014.08.25
 */
public interface Job extends Serializable {

    /**
     * 执行任务
     */
    Result run();
    /**
     * 获取唯一的jobId
     * @return
     */
    String getJobId();
}
