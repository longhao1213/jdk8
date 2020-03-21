package com.jdk.chapter5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: Main5.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/21 10:26
 */
public class Main5 {
    public static void main(String[] args){
        List<String> list = Arrays.asList("git", "springboot", "redis", "netty", "java", "html5","svn");

        // 返回字符串长度最长的元素
        System.out.println(list.stream().max(Comparator.comparing(s -> s.length())).get());

        // 返回字符串长度最小的元素
        System.out.println(list.stream().min(Comparator.comparing(s -> s.length())).get());
    }
}