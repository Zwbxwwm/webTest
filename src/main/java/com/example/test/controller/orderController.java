package com.example.test.controller;


import com.example.test.Service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/order")
public class orderController {

    @Autowired
    private IOrderService iOrderService;

    @RequestMapping("/create")
    public String createOrder(@RequestParam String passengerPhone) throws Exception {
        return iOrderService.create(passengerPhone);
    }
}
