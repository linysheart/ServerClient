package com.web.jobresult;

import com.web.job.Result;

public class TestResult implements Result {

    /**
     * 
     */
    private static final long serialVersionUID = -707726955104107381L;
    private String jobId;
    @Override
    public String getSaveResultBeanName() {
        return "testResultHandler";
    }

    @Override
    public String getResultStatus() {
        return "SUCCESS";
    }

    @Override
    public String getJobId() {
        return jobId;
    }
    public void setJobId(String jobId){
        this.jobId = jobId;
    }
}
