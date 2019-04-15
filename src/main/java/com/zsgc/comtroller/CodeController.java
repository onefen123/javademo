package com.zsgc.comtroller;

import com.zsgc.tool.RandomValidateCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class CodeController {
    @RequestMapping(value = "/getcode")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            System.out.println("错误!!");
        }
    }

    @RequestMapping(value = "/checkcode", method = RequestMethod.POST, headers = "Accept=application/json")
    public boolean CheckCodeController(String inputStr, HttpSession session) {
        try {
            //从session中获取随机数
//            String inputStr = requestMap.get("inputStr").toString();
            String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
            if (random == null) {
                return false;
            }
            if (random.equals(inputStr)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("错误!!");
            return false;
        }


    }


}
