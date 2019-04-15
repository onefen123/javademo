package com.zsgc.entity;

public class Book implements Comparable<Book>{
    private String name;
    private int age;

    public Book(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "名字:" + this.name  + ", 年龄:" + this.age;
    }

    @Override
    public int compareTo(Book o) {
        if (this.age>o.age){
            return 1;
        }else if (this.age<o.age){
            return -1;
        }else {
            return 0;
        }
    }
}
