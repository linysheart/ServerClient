package com.model;

import java.io.Serializable;

public class Job implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -4000699709751745208L;
    
    public JobResponse execute(){
        JobResponse response = new JobResponse();
        System.out.println("execute Job");
        return response;
    }
}
