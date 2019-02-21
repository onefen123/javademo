package com.zsgc.comtroller;

import com.zsgc.entity.Demo;
import com.zsgc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;
    @GetMapping("/demo")
    public Demo save(Demo demo){
          int a=demoService.save(demo);
        return demo;
    }

}
