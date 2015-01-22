package com.server.rmi.service.impl;

import org.springframework.stereotype.Service;

import com.server.rmi.service.RmiJobService;
import com.web.job.Job;
import com.web.job.Result;
import com.web.job.base.JobManager;
/**
 * 任务接口
 * @author linys
 * @version 2014-9-1
 * @category service
 */
@Service(value="rmiJobService")
public class RmiJobServiceImpl implements RmiJobService {
    /**
     * 获取任务接口
     * @return
     */
    public Job getJob(){
        try {
            Job job = JobManager.getInstance().get();
            return job;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 保存任务执行结果
     */
    public void saveJobResult(Result result){
        try {
            System.out.println("save result ....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
