package com.example.test.Service;

import javax.jms.JMSException;
import java.util.List;

public interface IMQService {
    void sendMsg(String msg) throws JMSException;

    List getMsg(String destination) throws JMSException;
}
