package com.zsgc.comtroller;

import com.zsgc.entity.User_validation;
import com.zsgc.tool.jsondata;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
public class ValidationController {
    @PostMapping("/validation")
    public Object validation(@Valid User_validation user_validation,BindingResult result){
        if (result.hasErrors()) {
            FieldError fieldError = result.getFieldError();
            String field = fieldError.getField();
            String msg = fieldError.getDefaultMessage();

            return new jsondata(0,field + ":" + msg);
        }

        System.out.println("开始注册用户...");
        return "success";


    }
}
