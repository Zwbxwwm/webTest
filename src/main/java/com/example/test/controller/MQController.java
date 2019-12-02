package com.example.test.controller;


import com.example.test.service.IMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.JMSException;
import java.util.List;

@ResponseBody
@Controller
@RequestMapping("/mq")
public class MQController {

    @Autowired
    private IMQService imqService;

    @RequestMapping(value = "/sendMessage",method = RequestMethod.GET)
    public void sendMessage(@RequestParam("message") String message) throws JMSException {
        String he = message;
        imqService.sendMsg(message);
    }

    @RequestMapping(value = "/getMessage",method = RequestMethod.POST)
    public List getMessage(@RequestParam("destination") String destination ) throws JMSException {
        List result = imqService.getMsg(destination);
        return result;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}
