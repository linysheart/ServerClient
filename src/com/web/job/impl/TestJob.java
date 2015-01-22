package com.web.job.impl;

import com.util.UniqidUtil;
import com.web.job.Job;
import com.web.job.Result;
import com.web.jobresult.TestResult;

public class TestJob implements Job {

    /**
     * 
     */
    private static final long serialVersionUID = 5251338923061539236L;
    private String jobId;
    @Override
    public Result run() {
        System.out.println(Thread.currentThread().getId() + " job runnning ");
        try {
            System.out.println(Thread.currentThread().getId() + " job sleep ");
            Thread.currentThread().sleep(10000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //this.jobId = System.currentTimeMillis() + "";
        TestResult result = new TestResult();
        result.setJobId(jobId);
        return result;
    }
    public TestJob(){
        this.jobId = UniqidUtil.createPrimaryKey();
        System.out.println(this.jobId);
    }
    @Override
    public String getJobId() {
        return this.jobId;
    }

}
