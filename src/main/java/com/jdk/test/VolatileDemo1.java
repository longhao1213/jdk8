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

    public int count = 0;

    public void test1(){
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo1 v1 = new VolatileDemo1();
        Thread t1 = new Thread(()->v1.test1(),"A");
        Thread t2 = new Thread(()->v1.test1(),"B");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(v1.count);
    }
}