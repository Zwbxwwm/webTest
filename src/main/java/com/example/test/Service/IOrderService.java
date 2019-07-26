package com.example.test.Service;

import org.springframework.web.bind.annotation.RequestParam;

public interface IOrderService {
    String create(String passengerPhone) throws Exception;
    void test(String param);
    String testDrools(String userName);
}
