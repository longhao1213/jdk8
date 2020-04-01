package com.jdk.chapter7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * FileName: Main1.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/24 19:44
 */
public class Main1 {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 5);

        System.out.println(list.stream().collect(Collectors.toList()));

        TreeSet<Integer> collect = list.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect);
    }
}