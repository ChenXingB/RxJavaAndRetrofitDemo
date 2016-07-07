package com.example.admin.rxjavaandretrofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by admin on 2016/6/17.
 */

public interface ServerAPI {
    @GET("/HKS_APP_Interface/AppLogin.ashx")
    Observable<HttpResult<ComEntity>> GetNotice (@Query("imei") String imei, @Query("mobilephone") String mobilephone, @Query("ver") String ver);

    @GET("HKS_APP_Interface/AddressList.ashx")
    Observable<HttpResult<List<ComBean>>>  getCom(@Query("staffid") String id);
}
