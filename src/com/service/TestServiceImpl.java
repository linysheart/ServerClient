package com.service;

import org.springframework.stereotype.Service;

import com.model.Job;
import com.model.JobResponse;

@Service(value="testService")
public class TestServiceImpl implements TestService {
    public Job getJob(){
        System.out.println("getJob");
        Job job = new Job();
        return job;
    }
    public String saveJobResponse(JobResponse response){
        System.out.println("saveJobResponse.");
        return "SUCCESS";
    }
}
