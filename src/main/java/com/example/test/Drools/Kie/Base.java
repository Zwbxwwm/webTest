package com.example.test.Drools.Kie;

import com.example.test.Drools.Test;
import com.example.test.common.Response;
import com.example.test.entity.didiOrder;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.SpreadsheetVersion;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.Format;

public class Base {
    public static KieSession getSession() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        //kmodule.xml 中定义的 ksession name
        KieSession kieSession = kieContainer.newKieSession("all-rules");
        return kieSession;
    }

    public static KieSession getSession(String agendaGroupName) {
        System.out.println("开始获取Session时刻："+System.currentTimeMillis());
        KieSession session = getSession();
        if (StringUtils.isNoneBlank(agendaGroupName)) {
            session.getAgenda().getAgendaGroup(agendaGroupName).setFocus();
        }
        System.out.println("获取到session的时刻是："+System.currentTimeMillis());
        return session;
    }

    public static void main(String[] args) {
        System.setProperty("drools.dateformat", "dd-MM-yyyy");
        KieSession kieSession = getSession("test-group1");
        System.out.println("引擎开始触发时间："+System.currentTimeMillis());
        didiOrder order = new didiOrder();
        order.setOrderAmount(new BigDecimal("50"));
        Response response = new Response();
        kieSession.insert(order);
        kieSession.insert(response);
        int count = kieSession.fireAllRules();
        System.out.println("引擎结束时间："+System.currentTimeMillis());
        System.out.println(count);
        System.out.println(order.getOrderId());
        System.out.println(response.getData());
        kieSession.dispose();
    }
}