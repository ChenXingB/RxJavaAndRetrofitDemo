package com.example.admin.rxjavaandretrofitdemo;

/**
 * Created by admin on 2016/6/18.
 */
public class ApiException extends RuntimeException  {
    public ApiException(String mst) {
        super(mst);
    }
}
