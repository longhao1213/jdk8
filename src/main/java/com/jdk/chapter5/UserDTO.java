package com.jdk.chapter5;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright (C), 2006-2010, ChengDu ybya info. Co., Ltd.
 * FileName: UserDTO.java
 *
 * @author lh
 * @version 1.0.0
 * @Date 2020/03/21 09:45
 */
@Data
public class UserDTO {
    private int userId;

    private String username;

    public UserDTO(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public UserDTO() {
    }
}