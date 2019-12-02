package com.example.test.drools.kie;

import lombok.Data;

/*
    关于人的描述->Person()对象, 该字段描述着员工工号，名字，等级，性别，年龄，工龄,职称等。
 */
@Data
public class Person {
    private String jobNum; //工号

    private String name;

    private int age;

    private int level; //等级分为L1 - L4,

    private int sex; // 1->‘男’ 0->‘女’

    private int workTime; //工龄，单位-年

    private String title; //职称分为A、B、C
}
