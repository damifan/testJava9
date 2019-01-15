package com.damifan.test.annotation;

/**
 * <p>
 *
 * @TODO </p>
 * @Author : WangLei
 * @Date : 2019/1/15
 */
public class User {

    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    @Init(value = "damifan")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
