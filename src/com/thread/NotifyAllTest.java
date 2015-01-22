package com.thread;

public class NotifyAllTest {
    public static Object obj = new Object();
    public static void main(String[] args) {
        ThreadB t1 = new ThreadB("t1");
        ThreadB t2 = new ThreadB("t2");
        ThreadB t3 = new ThreadB("t3");
        t1.start();
        t2.start();
        t3.start();
        try {
           System.out.println(Thread.currentThread().getName()+" sleep(3000)");
           Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         synchronized(obj) {
         // 主线程等待唤醒。
            System.out.println(Thread.currentThread().getName()+" notifyAll()");
            obj.notifyAll();
        }
    }
    static class ThreadB extends Thread{
        public ThreadB(String name){
            super(name);
        }
        @Override
        public void run() {
            synchronized (obj) {
                try {
                    
                    System.out.println(Thread.currentThread().getName() + " wait! ");
                    
                    obj.wait();
                    
                    System.out.println(Thread.currentThread().getName() + " continue! ");
                    
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }
    }
}


