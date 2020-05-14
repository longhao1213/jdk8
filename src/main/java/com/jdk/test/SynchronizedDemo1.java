package com.jdk.test;

import java.time.LocalDateTime;

/**
 * synchrosnized 关键字测试
 * 同步代码块
 * @author 码农猿
 */
public class SynchronizedDemo1 implements Runnable {

    public static final Object staticLockObj = new Object();

    /**
     * 全局变量
     * 创建一个计数器
     */
    private static int counter = 1;

    @Override
    // 修饰普通方法 与修饰代码块效果一致
//    public synchronized void run() {
    public void run() {
        LocalDateTime startDate = LocalDateTime.now();
        // 修饰代码块的方式 与修饰普通方法效果一致
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("线程 ：" + Thread.currentThread().getName() + " 当前计数器 ：" + (counter++));
                    System.out.println("开始时间 ：" + startDate + " 当前时间 ：" + LocalDateTime.now());
                    System.out.println();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        /**
         * 可以看出来，对于同一个对象来说，用synchronized修饰后，第一个线程会锁定该对象
         */
//        SynchronizedDemo1 syncThread = new SynchronizedDemo1();
//        new Thread(syncThread, "sync-thread-1").start();
//        new Thread(syncThread, "sync-thread-2").start();


//        =================================稍作改动
        /**
         * 可以看出来，对于不同的对象，该锁就不生效了
         * 如果this()中的对象变成了一个静态变量，那么锁又生效了，因为静态变量绑定在类上的
         */
        SynchronizedDemo1 synchronizedDemo1 = new SynchronizedDemo1();
        SynchronizedDemo1 synchronizedDemo2 = new SynchronizedDemo1();
        new Thread(synchronizedDemo1,"sync-thread-1").start();
        new Thread(synchronizedDemo2,"sync-thread-2").start();


    }
}
