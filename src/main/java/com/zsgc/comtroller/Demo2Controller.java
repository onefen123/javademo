package com.zsgc.comtroller;

import com.github.pagehelper.PageHelper;
import com.zsgc.entity.Demo;
import com.zsgc.service.Demo2Service;
import com.zsgc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo2")
public class Demo2Controller {
    @Autowired
    private Demo2Service demo2Service;

    @RequestMapping("/insert")
    public Demo save(Demo demo){
        int a=demo2Service.save(demo);
        return demo;
    }

    @RequestMapping("/updata")
    public int updata(Demo demo){
        return demo2Service.updata(demo);

    }

    @RequestMapping("/del")
    public int del(int id){
        return demo2Service.del(id);

    }

    @RequestMapping("/selectall")
    public List<Demo> selectall(){
        return demo2Service.selectall();
    }


    @RequestMapping("/select1")
    public Demo select1(int id){
        return demo2Service.select1(id);
    }

}
