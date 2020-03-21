package com.jdk.chapter5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: Main2.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/21 09:45
 */
public class Main2 {

    public static void main(String[] args) {
        // 对象转换
        List<User> list = Arrays.asList(new User(1, "anna", "123"),
                new User(2, "anna1", "1234"),
                new User(3, "anna2", "1235"),
                new User(4, "anna3", "1236"));

        List<Object> collect = list.stream().map(user -> new UserDTO(user.getId(), user.getName())).collect(Collectors.toList());

        System.out.println(collect);

        // filter()
        System.out.println(list.stream().filter(user -> user.getId() > 2).collect(Collectors.toList()));
    }
}