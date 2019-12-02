package com.example.test.selfMQ;

import java.io.IOException;

/**
 * @ClassName ProduceClient
 * @Description 消息产生类
 * @Author created by Zwb
 * @Date 2019/11/20 10:29
 * @Version 1.0
 */
public class ProduceClient {
    public static void main(String[] args) throws IOException {
        MyClient client = new MyClient();
        client.producer("消息2");
    }
}
