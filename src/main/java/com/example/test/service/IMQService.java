package com.example.test.service;

import javax.jms.JMSException;
import java.util.List;

public interface IMQService {
    void sendMsg(String msg) throws JMSException;

    List getMsg(String destination) throws JMSException;
}
