package com.zsgc.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Demo {
    private int id;
    private String name;
    private String mail;
    private int age;
//    @JSONField(format="yyyy-MM-dd")  //fastjson
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone ="GMT+8" )
    private Date timetime;

}
