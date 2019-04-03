package com.zsgc.comtroller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.zsgc.entity.User;
import com.zsgc.tool.jsondata;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.alibaba.druid.sql.ast.SQLPartitionValue.Operator.List;

@RestController
public class String_Object_Json_Controller {

    @RequestMapping("/obj2str")
    public String obj2str(){
        User user= new User("lwf","123456qq",35);
        return new Gson().toJson(user);
    }
    @RequestMapping("/str2obj")
    public Object str2obj(){
        String str="{\"id\":1,\"name\":\"lwf\",\"password\":\"12334f\",\"age\":35}";
        return new Gson().fromJson(str,User.class);
    }

    @RequestMapping("/str2obj_array")
    public Object str2obj_array(){
        String str="[{\"id\":1,\"name\":\"lwf\",\"password\":\"12334f\",\"age\":35},{\"id\":1,\"name\":\"lwf\",\"password\":\"12334f\",\"age\":35}]";
         List<User> list=new Gson().fromJson(str,new TypeToken<ArrayList<User>>(){}.getType());
        return list;
    }

    @RequestMapping("/obj2")
    public Object obj2(){
        User user= new User("lwf","123456qq",35);
        return new jsondata(1,user,"Your message!!!");
    }
}
