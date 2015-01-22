package com.web.job.base;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.web.job.Job;
import com.web.job.JobPool;

/**
 * 默认任务池
 * @author zhengzl
 * @since 2014.08.28
 */
public class DefaultJobPool implements JobPool {

    private static final long serialVersionUID = 3982129787374341500L;

    /**
     * 队列大小:默认10万个
     */
    public static int SIZE = 100000;
    
    /**
     * 工作池
     */
    private Queue<Job> jobPool = new ConcurrentLinkedQueue<Job>();
    
    public Job get() {
        return this.jobPool.poll();
    }

    public boolean put(Job job) {
        return (job != null) ? this.jobPool.offer(job) : false;
    }

    public int size() {
        return this.jobPool.size();
    }

    public boolean isEmpty() {
        return this.jobPool.isEmpty();
    }

    public boolean isFull() {
        //this.jobPool.size() == SIZE
        return false;
    }

    public boolean clear() {
        try {
            this.jobPool.clear();
            return true;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return false;
    }

//    public static void main(String[] args) throws InterruptedException {
//        JobManager jobPool = JobManager.getInstance();
//        for (int i = 0; i < 10000; i++) {
//            if (jobPool.isFull() == false) {
//                jobPool.put(new YHDOrderJob());
//            } else {
//                System.out.println("队列已满, 即将退出");
//                Thread.sleep(3000);
//                break;
//            }
//            System.out.println("jobPool.size = " + jobPool.getSize() + ", i = " + i);
//        }
//        System.out.println("complete");
//    }
}
