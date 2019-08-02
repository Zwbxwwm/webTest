package com.example.test.Drools.Container;

import com.example.test.Drools.Container.Impl.MyKieSession;
import org.kie.api.runtime.KieSession;

public interface ContainerPurpose {
    MyKieSession getSession();

    KieSession getSession(String group);

    void refresh();

    void releaseSession(KieSession session);

}
