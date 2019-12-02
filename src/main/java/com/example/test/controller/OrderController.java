package com.example.test.controller;


import com.example.test.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
@RequestMapping("/order")
public class OrderController {

    private static Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IOrderService iOrderService;

    @RequestMapping("/create")
    public String createOrder(@RequestParam String passengerPhone, HttpServletRequest request) throws Exception {
        log.info("获取request中的属性值，passengerPhone={}",request.getAttribute("passengerPhone"));
        log.info("获取request中的所有属性枚举={}",request.getAttributeNames());
        log.info("获取request中的Cookie数组={}",request.getCookies());
        log.info("获取request中的字符编码={}",request.getCharacterEncoding());
        log.info("获取request中body的长度={}",request.getContentLength());
        log.info("获取request中客户机与服务端之间的协议={}",request.getProtocol());
        log.info("获取request中客户机的IP地址={}",request.getRemoteAddr());
        log.info("获取request中客户机的名字={}",request.getRemoteHost());
        log.info("获取request中服务端的端口号={}",request.getServerPort());
        return iOrderService.create(passengerPhone);
    }

}
