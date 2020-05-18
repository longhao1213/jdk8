package com.jdk.test;


/**
 * Copyright (C), 2006-2010, ChengDu longsan info. Co., Ltd.
 * FileName: VolatileDemo1.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/05/14 22:21
 */
public class VolatileDemo1{

    public static volatile int count = 0;

    /**
     * volatile关键字不能保证原子性，只能保证可见性
     * 同时也禁止了指令重排序
     *  volatile使用场景
     *      对变量的写操作不依赖于当前值
     *      对变量没有包含在具有变量的不变式中
     */

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 10; i1++) {
                    System.out.println(++count);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }
    }
}