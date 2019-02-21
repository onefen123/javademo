package com.zsgc.service;

import com.zsgc.entity.Demo;
import com.zsgc.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Transactional
    public int save(Demo demo){
        return demoMapper.save(demo);

    }
}
