package com.example.test.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class didiUser {

    @Id
    private String passengerPhone;

    private String passengerPassword;

    private Date createTime;

    private Date updateTime;
}
