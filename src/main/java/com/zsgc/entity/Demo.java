package com.zsgc.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Demo {
    public int id;
    public String name;
    public String mail;
    private int age;
    private Date birthday;
//    @JSONField(format="yyyy-MM-dd")  //fastjson
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone ="GMT+8" )
    private Date timetime;

}
