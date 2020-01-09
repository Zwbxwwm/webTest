package com.example.test.utils;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.activemq.protobuf.BufferInputStream;
import org.mvel2.util.Make;

import java.io.*;
import java.lang.reflect.Field;

import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtil {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Administrator\\Desktop\\我的文件\\公司文件\\文档");
        File[] files = file.listFiles();
        for (File file1 : files) {
            String fileName = file1.getName();
            if (fileName.contains(".")) {
                System.out.println(file1.getName());
            } else {
                System.out.println("["+fileName+"]");
            }
        }
    }
}



