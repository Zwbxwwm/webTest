package com.example.test.drools.container.impl;


import lombok.Data;
import org.kie.api.runtime.KieSession;

@Data
public class MyKieSession{

    private static Integer activeTimes = 0;

    private  static  String version;

    private KieSession session;


}
