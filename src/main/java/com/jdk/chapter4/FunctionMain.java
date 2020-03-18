package com.jdk.chapter4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: Function.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/18 18:20
 */
public class FunctionMain {
    /**
     * 有传入参数 有返回值
     * @param args
     */
    public static void main(String[] args){
//        Function<Integer,String> function = new Function<Integer, String>() {
//        @Override
//        public String apply(Integer integer) {
//
//        }
//    }

        // 其中p为传入的参数 p旁边的括号可以省略 p也可以定义为任意字符
        java.util.function.Function<Integer,String> function = (p)->{
            System.out.println("babbabab");
            return p + 1 + "fweafwef";
        };
        System.out.println(function.apply(100));

        BiFunction<Integer,Integer,Integer> biFunction = (x,y)->x*y;

        System.out.println(biFunction.apply(2, 3));
    }

//
}