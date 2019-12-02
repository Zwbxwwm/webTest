package com.example.test.drools.container.impl;

import com.example.test.drools.container.Container;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.HashMap;

public class ContainerPurposeImpl implements Container {

    private final HashMap<String,KieSession> container = new HashMap<>();

    @Override
    public void init(){
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer =  kieServices.newKieClasspathContainer();
        KieSession kieSessions =  kieContainer.newKieSession("all-rules");
    }

    /*
    getSession();获取
     */
    @Override
    public MyKieSession getSession() {
        MyKieSession myKieSession = new MyKieSession();
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        //kmodule.xml 中定义的 ksession name
        KieSession kieSession = kieContainer.newKieSession("all-rules");
        myKieSession.setSession(kieSession);
        return myKieSession;
    }

    /*
    getSession(String group);根据groupId标识路径获取指定的session
     */
    @Override
    public KieSession getSession(String group) {
        return null;
    }

    @Override
    public void refresh(){

    }

    @Override
    public void releaseSession(KieSession session){

    }


    /*
    createSession();创建归组之后的session;
     */
    @Override
    public void createSession(String group) {

    }

    @Override
    public void createSession() {

    }
}
