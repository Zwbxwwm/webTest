package com.example.test.common;

public class Response<T> {
    private static int code;
    private static String msg;
    private T data;

    public static void setCode(int code) {
        Response.code = code;
    }

    public static void setMsg(String msg) {
        Response.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public Response(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public  Response(T data){
        this.data = data;
    }
    public Response(){
        this.msg = null;
    }

    public static <T>Response<T> success(T data){
        return new Response<>(data);
    }

}
