package com.jdk.chapter4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: ConsumerMain.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/18 18:36
 */
public class ConsumerMain {


    /**
     * 有传入参数,没有返回值
     * @param args
     */
    public static void main(String[] args) {
        Consumer<String> consumer = p -> System.out.println(p + ",在的");
        consumer.accept("在吗");


        // 典型用法
        List<String> list = Arrays.asList("1", "2");

        list.forEach(obj-> System.out.println(obj+"..."));

    }
}