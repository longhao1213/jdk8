package com.jdk.chapter5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: Main4.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/21 10:19
 */
public class Main4 {
    public static void main(String[] args){
        List<String> list = Arrays.asList("git", "springboot", "redis", "netty", "java", "html5");

        // 判断是否所有的元素长度都大于5
        System.out.println(list.stream().allMatch(s -> s.length() > 5));

        // 判断其中是否有元素的长度大于5
        System.out.println(list.stream().anyMatch(s -> s.length() > 5));
    }
}