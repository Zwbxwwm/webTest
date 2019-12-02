package com.example.test.selfMQ;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName Broker
 * @Description 消息处理中心
 * @Author created by Zwb
 * @Date 2019/11/20 9:39
 * @Version 1.0
 */
public class Broker {

    //队列储存消息的最大数量
    private final static int MAX_SIZE = 4;

    //保存信息的队列
    private final static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue(MAX_SIZE);

    public static void produce(String msg) {
        if (messageQueue.offer(msg)) {
            System.out.println("成功向消息处理中心投递消息："+msg+"，消息处理中心现在的容量为"+messageQueue.size());
        }else{
            System.out.println("消息队列已满");
        }
        System.out.println("======================================================");
    }

    public static String consumer() {
        String msg = messageQueue.poll();
        if (msg != null) {
            System.out.println("成功从消息处理中心中获取到消息：" + msg + "，消息处理中心现在的容量为：" + messageQueue.size());
        } else {
            System.out.println("消息处理中心的消息数量为0");
        }
        System.out.println("======================================================");

        return msg;
    }
































}
