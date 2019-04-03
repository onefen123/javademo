package com.zsgc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private int age;

    public User(String name,String password, Integer age) {
        super();
        this.name=name;
        this.name=password;
        this.age=age;
    }

}
