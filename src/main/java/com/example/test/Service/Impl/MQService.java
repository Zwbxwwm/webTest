package com.example.test.Service.Impl;

import com.example.test.Service.IMQService;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MQService implements IMQService {

    private Logger log = LoggerFactory.getLogger(IMQService.class);

    @Value("${mq.url}")
    private String url;

    @Value("${mq.queueName}")
    private String queueName;
    @Override
    public void sendMsg(String msg) throws JMSException {
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
        Destination destination = session.createQueue(queueName);
        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage(msg);
        producer.send(message);
        log.info(msg+"已发送...");
        connection.close();
    }

    @Override
    public List getMsg(String destination) throws JMSException {
        List result = new ArrayList();
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
        //创建一个消费者
        Destination target = session.createQueue(destination);
        MessageConsumer consumer = session.createConsumer(target);
        //7.创建一个监听器
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage= (TextMessage) message;
                try {
                    result.add(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //8.关闭连接
        connection.close();
        return result;
    }
}
