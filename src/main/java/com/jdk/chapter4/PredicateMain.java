package com.jdk.chapter4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: PredicateMain.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/18 18:53
 */
public class PredicateMain {

    /**
     * 有参数 返回值为boolean类型
     * @param args
     */
    public static void main(String[] args){
        Predicate<Integer> predicate =i -> i>10;

        System.out.println(predicate.test(1));

        // 做过滤使用
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Predicate<Integer> predicate2 = j -> j > 2;
        for (Integer integer : list) {
            if (predicate2.test(integer)) {
                System.out.println(integer);
            }
        }
    }
}