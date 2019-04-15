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
    @GetMapping("/sfz")
    public int is_sfz() {
        String sfz="341226199505052362";
        String regex="[1-8][0-7][0-7][0-9][0-9]{2}(19[0-9][0-9]|20[0-2][0-9])(0[1-9]|1[0-2])(([0-2][0-9])|30|31)([0-9]{3})([0-9xX])";

        int sfz_sum = 0;
        String sfz_arr[]=sfz.split("");
        int factor[] = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        String parity[] = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

        if(sfz.matches(regex)){
            for(int i=0;i<17;i++){
                sfz_sum += Integer.parseInt(sfz_arr[i])  * factor[i];
            };
            if(parity[sfz_sum % 11] .equals(sfz_arr[17].toUpperCase()) ){

                return Integer.parseInt(sfz_arr[16])%2==0 ? 2 : 1 ;
            } else {
                return 0;
            }
        }else {
            return 0;
        }


    }

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
