package com.zsgc.comtroller;

import com.zsgc.tool.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    @Autowired
    private MailUtil mailUtil;

    @RequestMapping("/mail")
    public void sendSimpleEmail() {
        String deliver = "3000-0000@163.com";
        String[] receiver = {"3006139@qq.com"};
        String[] carbonCopy = {"64818700@qq.com"};
        String subject = "账户成功注册通知!!!";
        String content = "你的账户成功注册,请登陆!!!";

        try {
            mailUtil.sendSimpleEmail(deliver, receiver, carbonCopy, subject, content);
        } catch (Exception e) {
            System.out.println("Send simple email failed");
            e.printStackTrace();
        }
    }

}
