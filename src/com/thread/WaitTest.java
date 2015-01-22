package com.thread;

public class WaitTest {
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA(" threada t1 ");
        synchronized (t1) {
            try {
                System.out.println(Thread.currentThread().getName() + " t1 started");
                t1.start();
                Thread.currentThread().sleep(2000L);
                System.out.println(Thread.currentThread().getName() + " t1 wait();");
                t1.wait();
                
                System.out.println(Thread.currentThread().getName() + " continue ");
                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
