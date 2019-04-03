package com.zsgc.comtroller;

import com.github.pagehelper.PageHelper;
import com.zsgc.entity.Demo;
import com.zsgc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin //跨域
//@CrossOrigin(origins = "http://xxx.com", maxAge = 3600)
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/insert")
    public Demo save(Demo demo){
          int a=demoService.save(demo);
          return demo;
    }

    @RequestMapping("/update")
    public int update(Demo demo){
        int res=demoService.update(demo);
        return res;
    }

    @RequestMapping("/del")
    public int del(Integer id){
        int res=demoService.del(id);
        return res;
    }

    @RequestMapping("/select")
    public Demo select(Integer id){
        return demoService.select(id);
    }

    @RequestMapping("/selectall")
    public List<Demo> select(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        System.out.println(111);
        return demoService.selectall();
    }

    @RequestMapping("/select5")
    public List<Demo> select5(String ordercolumn){
        return demoService.select5(ordercolumn);
    }

    @RequestMapping("/select6")
    public List<Demo> select6(String name,Integer age){
        return demoService.select6(name,age);
    }
}
