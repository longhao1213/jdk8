package com.jdk.chapter3.lambda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: Function.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/17 17:48
 */
public class Main {
    private final static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args){
        // 创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        }).start();
        // lambda
        new Thread(()-> System.out.println("123")).start();


        // 集合排序
        List<String> list = Arrays.asList("3", "2", "5");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        // lambda
        Collections.sort(list,(o1,o2)->o1.compareTo(o2));

        System.out.println(list);


        // 当你需要执行很多代码的时候,可以加入代码块{}
        new Thread(()->{
            System.out.println("1");
            System.out.println("2");
        }).start();
    }
}