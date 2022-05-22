package com.xxt.spring.common.entity;

/**
 * 供全局使用的简单POJO
 */
public class Fruit {

    private String name;

    public void init(){
        System.out.println("fruit被初始化了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                '}';
    }
}
