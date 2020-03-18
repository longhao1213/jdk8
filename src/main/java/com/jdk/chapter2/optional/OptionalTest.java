package com.jdk.chapter2.optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: OptionsTest.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/03 18:32
 */
public class OptionalTest {
    private final static Logger logger = LoggerFactory.getLogger(OptionalTest.class);

    public static void main(String[] args){
        Student student = new Student();

        // 传入值不能为null
        Optional<Student> opt = Optional.of(student);
        // 这种方式可以传null
//        Optional<Student> opt = Optional.ofNullable(student);


        // 判断opt中对象是否为空
        if (opt.isPresent()) {
            System.out.println("opt中对象不为空");
            Student student1 = opt.get();
        } else {
            System.out.println("opt中对象为空");
        }
    }
}