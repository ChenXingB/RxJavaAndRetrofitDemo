package com.example.admin.rxjavaandretrofitdemo;

/**
 * Created by admin on 2016/6/18.
 */

public class HttpResult<T> {
    private int Code;
    private String Msg;
    private T data;

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
