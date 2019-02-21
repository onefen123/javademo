package com.zsgc.mapper;

import com.zsgc.entity.Demo;
import org.apache.ibatis.annotations.*;

public interface DemoMapper {

    @Insert("insert into demo(name,age) values(#{name},#{age})")
    @Options(keyProperty = "id",keyColumn = "id",useGeneratedKeys = true)
    public  int save(Demo demo);

}
