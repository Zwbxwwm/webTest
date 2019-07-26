package com.example.test.Service.Impl;

import com.example.test.Service.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private IOrderService iOrderService;


    @Test
    public void create() throws Exception {
        String phone = "11123423423";
        String ticket = iOrderService.create(phone);
        System.out.println(ticket);
    }

    @Test
    public void test() {
        String param = "1123244";
        iOrderService.test(param);
    }

    @Test
    public void testDrools() {
        String OrderId = "12345678";
        System.out.println("测试结果："+iOrderService.testDrools(OrderId));
    }
}