package com.example.test.Drools.Kie;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.kie.api.runtime.KieSession;

public class SmartBuyTest {
    public static void main(String[] args) {
        System.setProperty("drools.dateformat", "dd-MM-yyyy");
        MyException exception = new MyException();
        ThrowException exception1 = new ThrowException();
        Dto dto = new Dto();
        KieSession session = Base.getSession("dto-group1");
        session.setGlobal("exception",exception);
        dto.setFlightInfo("南方航空公司");
        dto.setPriceInfo("1500");
        dto.setPassengers("3");
        dto.setCompanyId("1356");
        dto.setContactName("啦啦啦");

        session.insert(dto);
        session.insert(exception1);
        session.fireAllRules();


        if (exception != null) {
            System.out.println(exception.getMsg());
        }
        if (exception1 != null) {
            throw exception1;
        }


    }
}
