package com.jdk.chapter4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: Supplier.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/18 18:47
 */
public class SupplierMain {
    static {
        System.out.println("创建了SupplierMain");
    }

    private void put(String a) {
        System.out.println(a + "输出了");
    }

    /**
     * 没有传入参数,有返回值
     *
     * @param args
     */
    public static void main(String[] args) {
        Supplier supplier = () -> new SupplierMain();

        Supplier<SupplierMain> supplier1 = supplier;
        SupplierMain o = (SupplierMain) supplier.get();
        o.put("123");

        Student student = getStudent();
    }

    public static Student getStudent() {
        Supplier<Student> supplier = () -> {
            Student student = new Student();
            student.setAge(123);
            return student;
        };
        return supplier.get();
    }


    public static class Student {
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}