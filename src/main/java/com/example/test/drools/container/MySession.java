package com.example.test.drools.container;

import org.kie.api.runtime.KieSession;

public interface MySession extends KieSession {
    void dispose();

}
