package com.zsgc.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Demo {
    private int id;
    private String name;
    private String mail;
    private int age;
    @JSONField(format="yyyy-MM-dd")
    private Date timetime;


    public Date getTimetime() {
        return timetime;
    }


    public void setTimetime(Date timetime) {
        this.timetime = timetime;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
