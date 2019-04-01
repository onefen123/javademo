package com.zsgc.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/thyme")
public class ThymeController {
    @RequestMapping("/hello")
    public String thyme(Map<String,Object> map){
        map.put("name","lwf");
        return "thyme";
    }
}
