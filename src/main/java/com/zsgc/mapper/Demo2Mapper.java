package com.zsgc.mapper;

import com.zsgc.entity.Demo;

import java.util.List;

public interface Demo2Mapper {
    public  int save(Demo demo);
    public int updata(Demo demo);
    public int del(int id);
    public List<Demo> selectall();
    public Demo select1(int id);
}
