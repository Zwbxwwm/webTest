package com.example.test.Drools.Container;

import org.kie.api.runtime.KieSession;

public interface MySession extends KieSession {
    void dispose();

}
