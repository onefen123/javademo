package com.zsgc.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

@Data
public class Demo {
    private int id;
    private String name;
    private String mail;
    private int age;
    @JSONField(format="yyyy-MM-dd")
    private Date timetime;

}
