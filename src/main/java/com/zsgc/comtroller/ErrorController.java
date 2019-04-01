package com.zsgc.comtroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/err")
@RestController
public class ErrorController {
    @RequestMapping("/error")
    public String error(){
        int a=1/0;
        return "123";
    }
}
