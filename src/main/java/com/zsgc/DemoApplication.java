package com.zsgc;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonContainer;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootApplication
@MapperScan({"com.zsgc.mapper"})
//@MapperScan({"com.zsgc.mapper","com.zsgc.db"})
public class DemoApplication {
@Bean
public HttpMessageConverters fastJsonHttpMessageConverters(){
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter=new FastJsonHttpMessageConverter();
    FastJsonConfig fastJsonConfig=new FastJsonConfig();
    fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
    fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
    HttpMessageConverter<?> converter=fastJsonHttpMessageConverter;
    return new HttpMessageConverters(converter);

}
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
