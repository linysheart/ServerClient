package com.client;

import com.model.Job;
import com.model.JobResponse;
import com.service.TestService;


public class Client {
    private TestService testService;
    public void execute(){
        Job job = testService.getJob();
        JobResponse response = job.execute();
        testService.saveJobResponse(response);
    }
    /**
     * @return the testService
     */
    public TestService getTestService() {
        return testService;
    }
    /**
     * @param testService the testService to set
     */
    public void setTestService(TestService testService) {
        this.testService = testService;
    }
    
}
