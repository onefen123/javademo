package com.zsgc.comtroller;

import com.zsgc.tool.jsondata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@PropertySource({"classpath:application.properties"})
public class UploadController {
    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
    String folder=df.format(new Date());

    private static final String filepath="d:/upload/";
    private final String filepath2=filepath + folder + "/";



    @Value("${web.upload-path}")
    private String filepath1;
    @RequestMapping(value = "/upload")
    public Object upload(@RequestParam("img") MultipartFile file, HttpServletRequest request){

        file.isEmpty();//判断是否空
        file.getSize();//判断字体大小


        File filee=new File(filepath2);
        if(!filee.exists()){
            filee.mkdirs();
        }

        String name=request.getParameter("name");//获取表单值
        String filename=file.getOriginalFilename();//获取原始文件名
        String suffixname=filename.substring(filename.lastIndexOf("."));//获取扩展名
        filename= System.currentTimeMillis()+suffixname; //获取上传后的文件名

        File dest=new File(filepath2 + filename);
        try {
            file.transferTo(dest);
            return new jsondata(1,"successfully!",folder+"/"+filename);
        }catch (IllegalStateException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return new jsondata(1,"upload failed!");
    }
}
