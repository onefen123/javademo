package com.zsgc.comtroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@PropertySource({"classpath:application.properties"})
public class TestController {
    @Value("${test.b}")
    private String b;
    @RequestMapping("/t1")
    public String val(){
        return b;
    }


}
