package com.service;

import org.springframework.stereotype.Service;

import com.web.job.Job;
import com.web.job.base.JobManager;
import com.web.job.impl.TestJob;
@Service(value="testJobProducer")
public class TestJobProducer {
    public void execute(){
        System.out.println("producer produce job");
        for (int i = 0; i < 5; i++) {
            Job testJob = new TestJob();
            JobManager.getInstance().put(testJob);
        }
    }
}
