package com.service;

import com.model.Job;
import com.model.JobResponse;
/**
 * 提供的service接口
 * @author linys
 * @version 2014-8-30
 * @category
 */
public interface TestService {
    Job getJob();
    String saveJobResponse(JobResponse response);
}
