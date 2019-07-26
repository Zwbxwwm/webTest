package com.example.test.dao;

import com.example.test.entity.didiOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@SpringBootTest()
public class didiOrderRepositoryTest {
    @Autowired
    private didiOrderRepository didiOrderRepository;

    @Test
    public void test1() {
        didiOrder didiOrder = new didiOrder();

        didiOrder.setOrderId("111111111");
        didiOrder.setAdminPhone("1211111");
        didiOrder.setPassengerPhone("11111111");
        didiOrder.setEndAddress("佛山");
        didiOrder.setStartAddress("广州");
        didiOrder.setOrderAmount(new BigDecimal(3.12));
        didiOrder.setOrderStatus(0);
        didiOrder.setPayStatus(0);
        didiOrderRepository.save(didiOrder);
    }

    @Test
    public void findByOrderId() {
        String orderId = "1123244";
        System.out.println(didiOrderRepository.findByOrderId(orderId));
    }
}