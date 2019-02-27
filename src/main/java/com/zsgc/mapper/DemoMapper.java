package com.zsgc.mapper;

import com.zsgc.entity.Demo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DemoMapper {

    @Insert("insert into demo(name,age) values(#{name},#{age})")
    @Options(keyProperty = "id",keyColumn = "id",useGeneratedKeys = true)
    public  int save(Demo demo);

    @Update("update demo set name=#{name},age=#{age} where id=#{id}")
    public int update(Demo demo);

    @Delete("delete from demo where id=#{id}")
    public int del(Integer id);

    @Select("select * from demo where id=#{id}")
    public Demo select(Integer id);

    @Select("select * from demo")
    public List<Demo> selectall();

    //$
    @Select("select * from demo order by ${ordercolumn}")
    public List<Demo> select5(@Param("ordercolumn") String ordercolumn);

    //if
    @Select("<script>"+
            "select * from demo where 1 <if test='name !=null'>and name=#{name}</if> <if test='age !=null'>and age=#{age}</if>"
            +"</script>")
    public List<Demo> select6(@Param("name") String name,@Param("age") Integer age);

}
