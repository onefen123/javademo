package com.zsgc.service;

import com.zsgc.mapper.Demo2Mapper;
import com.zsgc.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Demo2Service {

    @Autowired
    private Demo2Mapper demo2Mapper;
    @Transactional
    public int save(Demo demo) {
        return demo2Mapper.save(demo);
    }

    @Transactional
    public int updata(Demo demo) {
        return demo2Mapper.updata(demo);
    }

    @Transactional
    public int del(int id) {
        return demo2Mapper.del(id);
    }

    @Transactional
    public List<Demo> selectall() {
        return demo2Mapper.selectall();
    }

    @Transactional
    public Demo select1(int id) {
        return demo2Mapper.select1(id);
    }
}
