package com.jdk.chapter7;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * FileName: Main4.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/24 20:39
 */
public class Main4 {

    public static void main(String[] args){
        // group by 分组
        List<Student> list = Arrays.asList(new Student(12,"南充"),
                new Student(15,"北京"),
                new Student(13,"南充"),
                new Student(12,"上海"),
                new Student(12,"南充"),
                new Student(13,"北京"));

        list.stream().collect(Collectors.groupingBy(obj -> obj.getAddress())).forEach((key,value)->{
            System.out.println("====");
            System.out.println(key);
            value.forEach(obj -> System.out.println(obj.getAge()));
        });
//        System.out.println(list.stream().collect(Collectors.groupingBy(obj -> obj.getAge())));

        // 分组后统计
        list.stream().collect(Collectors.groupingBy(obj -> obj.getAge(), Collectors.counting())).forEach((key,value)-> System.out.println(key+"有"+value+"个"));

        IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("一共有" + collect.getCount());
        System.out.println("平均年龄:" + collect.getAverage());
        System.out.println("最大年龄"+collect.getMax());
    }

    @Data
    public static class Student{
        private int age;
        private String address;

        public Student(int age, String address) {
            this.age = age;
            this.address = address;
        }
    }
}