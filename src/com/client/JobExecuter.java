package com.client;

import com.server.rmi.service.RmiJobService;
import com.web.job.Job;
import com.web.job.Result;
/**
 * 任务执行器
 * @author linys
 * @version 2014-9-1
 * @category
 */
public class JobExecuter {
    
    private RmiJobService jobService;
    /**
     * 执行的线程数
     */
    private Integer execThreadCount;
    public static final Long initThreadExceptionSleepTime = 1000L;
    
    public void exec(){
        if(execThreadCount != null && execThreadCount > 0){
            for (int i = 0; i < execThreadCount; i++) {
                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        Long exceptionSleepTime = initThreadExceptionSleepTime;
                        JobExecuter jobExecuter = JobExecuter.this;
                        while (true) {
                            try {
                                Job job = jobExecuter.jobService.getJob();
                                if(job != null){
                                    exceptionSleepTime = initThreadExceptionSleepTime;
                                    System.out.println(Thread.currentThread().getId() + " job running ...");
                                    Result result = job.run();
                                    jobExecuter.jobService.saveJobResult(result);
                                } else {
                                    System.out.println(Thread.currentThread().getId() + "job is null ...");
                                }
                                System.out.println(Thread.currentThread().getId() + "job over ...");
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println(" rmi 对接发生异常，线程等待: "+ exceptionSleepTime +" ms");
                                try {
                                    Thread.sleep(exceptionSleepTime);
                                } catch (InterruptedException e1) {
                                    e1.printStackTrace();
                                }
                                exceptionSleepTime *= 2;
                                if(exceptionSleepTime > 512000L){
                                    exceptionSleepTime = initThreadExceptionSleepTime;
                                }
                            }
                        }
                    }
                });
                System.out.println(thread.getId()+ " 线程被创建.");
                thread.start();
            }
        }
    }
    
    /**
     * @return the jobService
     */
    public RmiJobService getJobService() {
        return jobService;
    }
    /**
     * @param jobService the jobService to set
     */
    public void setJobService(RmiJobService jobService) {
        this.jobService = jobService;
    }

    /**
     * @return the execThreadCount
     */
    public Integer getExecThreadCount() {
        return execThreadCount;
    }

    /**
     * @param execThreadCount the execThreadCount to set
     */
    public void setExecThreadCount(Integer execThreadCount) {
        this.execThreadCount = execThreadCount;
    }
    
}
