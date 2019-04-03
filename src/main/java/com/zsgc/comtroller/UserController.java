package com.zsgc.comtroller;

import com.zsgc.entity.User;
import com.zsgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    //注册
    @RequestMapping(value = "/register",method={RequestMethod.GET,RequestMethod.POST})
    public Integer register(User user, Model model) {
        userService.addUser(user);
        model.addAttribute("msg","注册成功,请登陆");
        return 1;
    }


    //登录
    @RequestMapping(value = "/login",method={RequestMethod.POST})
    public int Login(User user, Model model, HttpSession session) {
        User user1 = userService.checkUser(user);
        if(user.getPassword().equals(user1.getPassword())){
            session.setAttribute("user1",user1);
            return 1;
        }else {
            return 0;
        }
    }

    //注销
    @RequestMapping("/logout")
    public Integer Logout(HttpSession session) {
        System.out.println(session);
        session.invalidate();
        System.out.println("111"+session);
        return 1;
    }
}
