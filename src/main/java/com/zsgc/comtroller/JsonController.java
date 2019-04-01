package com.zsgc.comtroller;

import com.zsgc.entity.Demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class JsonController {
    @RequestMapping("/json")
   public Demo getdemo(){
       Demo demo=new Demo();
       demo.setId(1);
       demo.setName("lwf");
       demo.setTimetime(new Date());
       return demo;
   }
}
