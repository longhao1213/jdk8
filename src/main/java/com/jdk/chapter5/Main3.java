package com.jdk.chapter5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: Main3.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/21 10:02
 */
public class Main3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("git", "springboot", "redis", "netty", "java", "html5");

        // sorted函数对字符串  默认采用首字符排序
        System.out.println(list.stream().sorted().collect(Collectors.toList()));

        // 采用字符串长度排序
        System.out.println(list.stream().sorted(Comparator.comparing(obj -> obj.length())).collect(Collectors.toList()));

        // 采用字符串长度排序 并且反转
        System.out.println(list.stream().sorted(Comparator.comparing(string -> string.length(), Comparator.reverseOrder())).collect(Collectors.toList()));
        // 同上方式 采用lambda方式写法
        System.out.println(list.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList()));

        // 同上规则 并且只取前2个
        System.out.println(list.stream().sorted(Comparator.comparing(String::length).reversed()).limit(2).collect(Collectors.toList()));
    }
}