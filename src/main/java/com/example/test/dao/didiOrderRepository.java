package com.example.test.dao;

import com.example.test.entity.didiOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface didiOrderRepository extends JpaRepository<didiOrder,String> {
    didiOrder findByOrderId(String id);
}
