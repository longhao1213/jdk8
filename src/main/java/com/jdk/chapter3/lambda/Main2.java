package com.jdk.chapter3.lambda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: Main2.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/17 18:46
 */
public class Main2 {
    private final static Logger logger = LoggerFactory.getLogger(Main2.class);

    public static void main(String[] args) {
        System.out.println(operator(2, 3, (x, y) -> {
            int z = x * y;
            return z + 100;
        }));
    }

    public static int operator(Integer x, Integer y, OperFunction<Integer, Integer> of) {
        return of.operator(x, y);
    }
}