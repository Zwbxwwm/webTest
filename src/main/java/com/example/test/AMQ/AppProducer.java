package com.example.test.AMQ;

import org.apache.activemq.ActiveMQConnectionFactory;
/*
    定义生产者
 */
import javax.jms.*;

public class AppProducer {
    //61616为activemq默认端口
    private static final String URL="tcp://127.0.0.1:61616";
    private static final String queueName="queue-test";
    public static void main(String[] args) throws JMSException {
        //1.创建ConnectionFactory
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(URL);
        //2.创建Connection
        Connection connection=connectionFactory.createConnection();
        //3.启动连接
        connection.start();
        //4.创建会话
        //第一个参数为是否支持事务
        //第二个参数为自动确认，客户端发送和接收消息不需要做额外的工作。哪怕是接收端发生异常，也会被当作正常发送成功
        Session session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建一个目标
        Destination destination=session.createQueue(queueName);
        //6.创建一个生产者
        MessageProducer producer=session.createProducer(destination);
        for(int i=0;i<100;i++){
            //7.创建消息
            TextMessage textMessage=session.createTextMessage("text"+i);
            //8.发布消息
            producer.send(textMessage);
            System.out.println("发送消息"+textMessage.getText());
        }
        //9.关闭连接
        connection.close();
    }

}