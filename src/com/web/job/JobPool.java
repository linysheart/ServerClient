package com.web.job;

import java.io.Serializable;


/**
 * 作业池JobPool接口：提供Job池最基本的操作，JobPool只关注业务逻辑接口，不关注Job具体的存储介质、存取方式等
 * @author zhengzl
 * @since 2014.08.28
 */
public interface JobPool extends Serializable {
    /**
     * 获取一个Job
     * @return 一个Job
     */
    public Job get();

    /**
     * 存放一个Job
     * @param job 要存放的Job
     * @return 是否成功
     */
    public boolean put(Job job);

    /**
     * 获取Job池中Job的数目
     * @return Job池中Job数目
     */
    public int size();

    /**
     * 判断Job池是否为空
     * 
     * @return Job池是否为空
     */
    public boolean isEmpty();

    /**
     * 判断Job池是否满载
     * 
     * @return Job池是否满载
     */
    public boolean isFull();

    /**
     * 清空Job池
     * 
     * @return 是否清空Job池
     */
    public boolean clear();
}