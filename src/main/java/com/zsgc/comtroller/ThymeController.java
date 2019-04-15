package com.zsgc.comtroller;

import com.zsgc.entity.Demo;
import com.zsgc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/thyme")
public class ThymeController {
    @RequestMapping("/t")
    public String thyme(Map<String,Object> map,String msg, Model model){
        map.put("name","lwf");
        model.addAttribute("url","www.xxx.com");//Model方法
        model.addAttribute("html","<span style='color:red'>ABC</span>");//html元素


        return "thyme";
    }
    @RequestMapping("/t1")
    public String thyme1(Model model){
        Demo demo=new Demo();
        demo.setName("lwf");
        demo.setMail("123@qq.cc");
        demo.setAge(12);
        demo.setBirthday(new Date());
        model.addAttribute("user",demo);

//        逻辑:lt,gt,le,ge,eq,ne
        return "thyme1";
    }
    @RequestMapping("/t2")
    public String thyme2(Model model){
        //list
        List<Demo> demos=new ArrayList<Demo>();
        Demo demo=new Demo();
        demo.setName("lwf1");
        demo.setMail("123@qq.cc");
        demo.setAge(11);
        demos.add(demo);

        demo.setName("lwf2");
        demo.setMail("125@qq.cc");
        demo.setAge(13);
        demos.add(demo);
        model.addAttribute("demos",demos);
        //map
        Map<String,Demo> demoss=new HashMap<String,Demo>();
        demo.setName("lwf1");
        demo.setMail("122@qq.cc");
        demo.setAge(16);
        demoss.put("user1",demo);

        demo.setName("lwf2");
        demo.setMail("125@qq.cc");
        demo.setAge(13);
        demoss.put("user2",demo);
        model.addAttribute("demoss",demoss);

        model.addAttribute("msg","我是消息!!!");
        return "thyme2";
    }

    @RequestMapping("/t3")
    public String thyme3(Map<String,Object> map){
        map.put("name","lwf");
        return "thyme3";
    }

}
