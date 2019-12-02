package com.example.test.drools.container;

import com.example.test.drools.container.impl.MyKieSession;
import org.kie.api.runtime.KieSession;

public interface ContainerPurpose {
    MyKieSession getSession();

    KieSession getSession(String group);

    void refresh();

    void releaseSession(KieSession session);

}
