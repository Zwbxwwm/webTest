package com.example.test.Drools.Container.Impl;


import lombok.Data;
import org.kie.api.runtime.KieSession;

@Data
public class MyKieSession{

    private static Integer activeTimes = 0;

    private  static  String version;

    private KieSession session;


}
