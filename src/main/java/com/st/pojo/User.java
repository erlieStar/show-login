package com.st.pojo;

import lombok.Data;

/**
 * @Author: lilimin
 * @Date: 2019/3/24 18:13
 */
@Data
public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
