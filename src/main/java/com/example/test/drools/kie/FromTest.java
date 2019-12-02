package com.example.test.drools.kie;

import org.kie.api.runtime.KieSession;


public class FromTest {
    public static void main(String[] args) {
        System.setProperty("drools.dateformat", "dd-MM-yyyy");
        Base base = new Base();
        KieSession kieSession = base.getSession("from-groupA");
        From from = new From();
        Person person = new Person();
        person.setAge(18);
        person.setJobNum("11111");
        person.setLevel(3);
        person.setTitle("C");
        person.setSex(1);
        person.setWorkTime(9);
        from.setPerson(person);
        kieSession.insert(from);
        kieSession.fireAllRules();
        System.out.println(from.getRatio());
    }
}