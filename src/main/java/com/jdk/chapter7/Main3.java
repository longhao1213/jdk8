package com.jdk.chapter7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * FileName: Main3.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/24 20:26
 */
public class Main3 {
    public static void main(String[] args){

        // 简单集合分组
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> collect = list.stream().collect(Collectors.partitioningBy(obj -> obj > 3));
        System.out.println(collect);

    }
}