package com.example.test.common.Enum;

public enum PayStatus {
    NEW_ORDER(0,"未支付"),
    FINISH_ORDER(1,"已支付"),;

    //订单支付状态

    private final int code;
    private final String msg;

    PayStatus(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
