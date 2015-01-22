package com.web.job;

import java.io.Serializable;

/**
 * 任务结果
 * @author zhengzl
 * @since 2014.09.01
 */
public interface Result extends Serializable {
    /**
     * 获取保存结果的bean的名称
     * @return
     */
    String getSaveResultBeanName();
    /**
     * 获取结果的状态
     * @return
     */
    String getResultStatus();
    /**
     * 获取该结果的JobId
     * @return
     */
    String getJobId();
}
