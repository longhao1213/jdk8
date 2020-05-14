package com.jdk.test;

import java.time.LocalDateTime;

/**
 * synchrosnized 关键字测试
 * 同步-静态方法
 *
 * @author 码农猿
 */
public class SynchronizedDemo3 implements Runnable {
    private static int counter = 1;
    
    /**
     * 静态的同步方法
     */
    public synchronized static void method() {
        LocalDateTime startDate = LocalDateTime.now();
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
    @Override
    public void run() {
        method();
    }

    /**
     *  虽然使用了两个对象，但是却保持了同步，这是因为run中调用了静态方法method
     *  而静态方法是属于同一类的，所以syncThread1和syncThread2相当于使用的同一把锁
     * @param args
     */
    public static void main(String[] args){
        SynchronizedDemo3 syncThread1 = new SynchronizedDemo3();
        SynchronizedDemo3 syncThread2 = new SynchronizedDemo3();
        new Thread(syncThread1, "sync-thread-1").start();
        new Thread(syncThread2, "sync-thread-2").start();

    }
}
