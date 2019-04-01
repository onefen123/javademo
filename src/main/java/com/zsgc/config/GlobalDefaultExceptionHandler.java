package com.zsgc.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public String defaultExceptionHandler(HttpServletRequest req,Exception e){
//    return "System error!";
//    }
}
