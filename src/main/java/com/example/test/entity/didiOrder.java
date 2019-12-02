package com.example.test.entity;

import com.example.test.common.Enum.OrderStatus;
import com.example.test.common.Enum.PayStatus;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/*
create table `didi_order` (
    `order_id` varchar(32) not null,
    `passenger_phone` varchar(32) not null comment '乘客电话',
    `admin_phone` varchar(32) not null comment '管理员电话',
    `start_address` varchar(64) not null comment '出发地址',
    `end_address` varchar(64) not null comment '目的地点',
    `order_amount` decimal(8,2) not null comment '订单总金额',
    `order_status` tinyint(3) not null default '0' comment '订单状态, 默认为新下单',
    `pay_status` tinyint(3) not null default '0' comment '支付状态, 默认未支付',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`order_id`)
);
 */
@Entity
@Data
@DynamicUpdate
public class didiOrder {
    @Id
    private String orderId;

    private String passengerPhone;

    private String adminPhone;

    private String startAddress;

    private String endAddress;

    private BigDecimal orderAmount;

    private Integer orderStatus = OrderStatus.NEW_ORDER.getCode();

    private Integer payStatus = PayStatus.NEW_ORDER.getCode();

    private Date createTime;

    private Date updateTime;


    public static void test() {
        System.out.println();
    }
}
