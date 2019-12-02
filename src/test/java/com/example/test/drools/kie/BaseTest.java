package com.example.test.drools.kie;

import com.example.test.entity.didiOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest extends Base {
    @Test
    public void test(){
        System.setProperty("drools.dateformat", "dd-MM-yyyy");
        KieSession kieSession = getSession();

        didiOrder order = new didiOrder();
        order.setOrderAmount(new BigDecimal("1000"));

        kieSession.insert(order);

        int count = kieSession.fireAllRules();

        System.out.println(count);
        System.out.println(order.getOrderId());

        kieSession.dispose();
    }
}