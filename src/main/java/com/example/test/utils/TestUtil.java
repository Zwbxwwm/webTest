package com.example.test.utils;

import net.bytebuddy.build.ToStringPlugin;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestUtil {
    public static void main(String[] args) {
        A a = new A("AAA", "BBB", "CCC", "DDD");
        System.out.println(toString(a));
    }

    public static String toString(Object obj) {
        Class clazz = obj.getClass();
        StringBuffer sb = new StringBuffer();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                String name = fields[i].getName();
                sb.append(name).append("=");
                // 使用反射直接访问 private 属性值
                fields[i].setAccessible(true);
                sb.append((String) fields[i].get(obj));
                if (i != fields.length - 1) {
                    sb.append("|");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

class A {

    private String name1;
    private String name2;
    private String name3;
    private String name4;

    public A(){
    }

    public A(String name1, String name2, String name3, String name4) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }
}
