package com.jdk.chapter4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: Main.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/18 19:10
 */
public class Main {

    public static void main(String[] args){
        // 使用双冒号::来构造静态函数的引用
        Function<String,Integer> function = Integer::parseInt;
        System.out.println(function.apply("123"));

        // 使用双冒号::来构造非静态函数
        String test = "123456789";
        Function<Integer, String> function1 = test::substring;
        System.out.println(function1.apply(3));

        // 使用双冒号::来构造构造函数
        BiFunction<String, Integer, User> function2 = User::new;
        System.out.println(function2.apply("anna", 2));

        Function<String,User> function3 = User::new;
        System.out.println(function3.apply("anna"));


    }

    public static class User{
        private String name;

        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public User(String name) {
            this.name = name;
        }

        public User(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}