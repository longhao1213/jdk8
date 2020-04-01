package com.jdk.chapter7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FileName: Main2.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/24 20:00
 */
public class Main2 {
    public static void main(String[] args){
        List<String> list = Arrays.asList("git", "svn", "java");

        /**
         * 字符串拼接
         */
        System.out.println(list.stream().collect(Collectors.joining()));

        // 加上连接符号
        System.out.println(list.stream().collect(Collectors.joining("&")));

        // 加上连接符号 在首尾也加上自定义符号
        System.out.println(list.stream().collect(Collectors.joining("!", "&", "~")));
    }
}