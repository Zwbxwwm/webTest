package com.example.test.selfMQ;

import java.io.IOException;

/**
 * @ClassName ConsumerClient
 * @Description 消息队列消费类
 * @Author created by Zwb
 * @Date 2019/11/20 10:36
 * @Version 1.0
 */
public class ConsumerClient {
    public static void main(String[] args) throws IOException {
        MyClient client = new MyClient();
        client.consumer();
    }
}
