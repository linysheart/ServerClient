package com.thread;

public class ThreadA extends Thread {
    public ThreadA(String name){
        super(name);
    }
    
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" ready for run.");
        synchronized (this) {
            System.out.println(Thread.currentThread().getName()+" running!");
            try {
                Thread.currentThread().sleep(5000L);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("线程A "+Thread.currentThread().getName()+"call Notify!");
            notify();
            System.out.println("线程A "+Thread.currentThread().getName()+" notified !");
        }
    }
}
