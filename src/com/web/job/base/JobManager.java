package com.web.job.base;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.web.job.Job;
import com.web.job.JobPool;

/**
 * 任务池管理器
 * @author zhengzl
 * @since 2014.08.28
 */
public class JobManager {

    /**
     * 管理器单例对象
     */
    private static JobManager instance = null;
    /**
     * 默认任务池
     */
    public final static int DEFAULT_POOL = 1;
    /**
     * 任务池map
     */
    private Map<Integer, JobPool> map = new ConcurrentHashMap<Integer, JobPool>(10);
    
    private JobPool jobPool;
    private Set<String> jobIdSet = new HashSet<String>();
    /**
     * 获取任务
     * @return Job
     * @throws InterruptedException 
     */
    public Job get() throws InterruptedException {
        synchronized (jobPool) {
            if(jobPool.size() <= 0){
                System.out.println(Thread.currentThread().getId() + " job 池大小为空,等待....");
                jobPool.wait();
            }
            System.out.println(Thread.currentThread().getId() + " 线程被唤醒.获取job");
            System.out.println("jobPool size is " + this.jobPool.size());
            Job job = jobPool.get();
            if(job != null){
                if(jobIdSet.contains(job.getJobId())){
                    System.out.println("jobId...重复");
                }
                this.jobIdSet.add(job.getJobId());
            }
            return job;
        }
    }
    /**
     * 存入任务
     * @param job
     * @return boolean
     */
    public boolean put(Job job) {
        synchronized (jobPool) {
            boolean isPut = this.jobPool.put(job);
            System.out.println(Thread.currentThread().getId() + " put Job And notifyAll;");
            System.out.println("jobPool size is " + this.jobPool.size());
            jobPool.notifyAll();
            return isPut;
        }
    }
    /**
     * 获取任务池大小
     * @return int
     */
    public int getSize() {
        return this.jobPool.size();
    }
    /**
     * 任务池是否为空
     * @return boolean
     */
    public boolean isEmpty() {
        return this.jobPool.isEmpty();
    }
    /**
     * r任务池是否已满
     * @return boolean
     */
    public boolean isFull() {
        return this.jobPool.isFull();
    }
    /**
     * 清空任务池
     * @return boolean
     */
    public boolean clear() {
        return this.jobPool.clear();
    }
    /**
     * 获取默认任务池
     * @return JobPool
     */
    private JobPool getDefaultJobPool() {
        return this.getJobPool(DEFAULT_POOL);
    }
    /**
     * 根据KEY获取任务池
     * @param pool
     * @return JobPool
     */
    private synchronized JobPool getJobPool(Integer key) {
        return (key != null && this.map.containsKey(key)) ? this.map.get(key) : null;
    }
    /**
     * 获取管理器单例对象
     * @return
     */
    public static JobManager getInstance() {
        if (instance == null) {
            synchronized (JobManager.class) {
                if (instance == null) {
                    instance = new JobManager();
                }
            }
        }
        return instance;
    }
    
    /**
     * 私有化无参构造函数
     */
    private JobManager() {
        super();
        JobPool jobPool = new DefaultJobPool();
        this.map.put(DEFAULT_POOL, jobPool);
        this.jobPool = this.getDefaultJobPool();
    }

    public static void main(String[] args) {
        JobManager jobManager = JobManager.getInstance();
        System.out.println(jobManager.jobPool);
    }
}
