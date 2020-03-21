package com.jdk.chapter5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: Main1.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/21 09:37
 */
public class Main1 {
    public static void main(String[] args){
        List<String> list = Arrays.asList("1", "2", "3");

        List<String> collect = list.stream().map(text -> "第" + text).collect(Collectors.toList());
        System.out.println(collect);
    }
}
