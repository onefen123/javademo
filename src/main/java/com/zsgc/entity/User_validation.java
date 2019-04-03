package com.zsgc.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class User_validation {

    @NotNull
    private String name;
    @NotBlank //只能String上,不为null,且调用trim()后,长度>0
    private String password;
    @Past  //过去时间
    private Date date1;
    @Future  //将来时间
    private Date date2;
    @Email
    private String mail;
    @Pattern(regexp="^((13[0-9])|(15[^4,\\D])|(18[0,3-9]))\\d{8}$", message="手机号格式不正确")
    private String phone;
    @Min(1)
    @Max(100)
    private Integer age;
}
