package com.jdk.chapter3.lambda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: OperFunction.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/17 18:53
 */
@FunctionalInterface
public interface OperFunction<R,T> {
    R operator(T t1,T t2);
}