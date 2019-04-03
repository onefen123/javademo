package com.zsgc.mapper;


import com.zsgc.entity.Demo;
import com.zsgc.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Insert("insert into user(name,password,age) values(#{name},#{password},#{age})")
    @Options(keyProperty = "id",keyColumn = "id",useGeneratedKeys = true)
    public  int save(User user);

    @Select("select * from user where name=#{name}")
    public User checkUser(String name);
}
