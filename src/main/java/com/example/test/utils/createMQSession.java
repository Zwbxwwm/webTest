package com.example.test.utils;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

public class createMQSession {

    public static Session create(String url) throws JMSException {
        //1.创建ConnectionFactory
        ConnectionFactory connectionFactory =new ActiveMQConnectionFactory(url);
        //2.创建Connection
        Connection connection = connectionFactory.createConnection();
        //3.启动连接
        connection.start();
        //4.创建会话
        //第一个参数为是否支持食事务
        //第二参数是在发送消息之后是否需要确认消息接收到，这里标记为自动确认，
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        return session;
    }
}
