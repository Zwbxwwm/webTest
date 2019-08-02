package com.example.test.Drools.Kie;

public class ThrowException extends  RuntimeException {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ThrowException(String msg) {
        super(msg);
    }
    public ThrowException() {

    }
}
