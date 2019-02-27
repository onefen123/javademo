package com.zsgc.service;

import com.zsgc.entity.Demo;
import com.zsgc.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Transactional
    public int save(Demo demo){
        return demoMapper.save(demo);
    }

    @Transactional
    public int update(Demo demo){
        return demoMapper.update(demo);
    }

    @Transactional
    public int del(Integer id){
        return demoMapper.del(id);
    }

    @Transactional
    public Demo select(Integer id){
        return demoMapper.select(id);
    }

    @Transactional
    public List<Demo> selectall(){
        return demoMapper.selectall();
    }

    @Transactional
    public List<Demo> select5(String ordercolumn){
        return demoMapper.select5(ordercolumn);
    }

    @Transactional
    public List<Demo> select6(String name,Integer age){
        return demoMapper.select6(name,age);
    }
}
