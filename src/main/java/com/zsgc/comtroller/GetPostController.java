package com.zsgc.comtroller;

import com.zsgc.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/gp")
public class GetPostController {
    private Map<String,Object> params=new HashMap<>();
    @RequestMapping(value="/get1/{userid}/{cityid}",method = RequestMethod.GET)
    //@PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中：URL 中的 {xxx} 占位符可以通过@PathVariable(“xxx“) 绑定到操作方法的入参中
    public Object get1(@PathVariable("userid")String userid, @PathVariable String cityid){
        params.clear();
        params.put("userid",userid);
        params.put("cityid",cityid);
        return params;
    }

    @GetMapping(value="/get2")
    //设置默认值和必填
    public Integer get2(@RequestParam(defaultValue ="123" ,required = true)int page){
        return page;
    }

    @GetMapping(path="/get3")
    public String get3(@RequestHeader("access_token") String accesssToken){
        return accesssToken;
    }







}
