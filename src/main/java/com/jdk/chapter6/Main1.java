package com.jdk.chapter6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: Main1.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/23 19:54
 */
public class Main1 {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // 普通流
//        numbers.stream().forEach(System.out::println);

        // 并行流 多线程
//        numbers.parallelStream().forEach(System.out::println);

        // 减少
        System.out.println(numbers.stream().reduce((x, y) -> x + y).get());

        // 加上初始值
        System.out.println(numbers.stream().reduce(100, (x, y) -> x + y));

        // 求最大值
        System.out.println(numbers.stream().reduce((x, y) -> x > y ? x : y).get());
    }
}