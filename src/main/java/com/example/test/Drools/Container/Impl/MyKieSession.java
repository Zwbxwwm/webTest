package com.example.test.Drools.Container.Impl;


import lombok.Data;
import org.kie.api.runtime.KieSession;

@Data
public class MyKieSession{
    private final Integer activeTimes = 0;

    private KieSession session;

}
