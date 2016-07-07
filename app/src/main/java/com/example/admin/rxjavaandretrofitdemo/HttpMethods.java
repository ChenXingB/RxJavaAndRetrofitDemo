package com.example.admin.rxjavaandretrofitdemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2016/6/18.
 */

public class HttpMethods {
    public static final String BASE_URL = "http://192.168.1.193:8887";
    //    public static final String BASE_URL = "http://222.76.213.16:8887";
    public static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private ServerAPI serverAPI;
    private LiftAll liftAll = new LiftAll();

    private HttpMethods(){
        OkHttpClient.Builder httpClientBuilder  = new  OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serverAPI = retrofit.create(ServerAPI.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder{
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    public static HttpMethods getInstance(){
        return  SingletonHolder.INSTANCE;
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.getCode() != 200) {
                throw new ApiException(httpResult.getMsg());
            }
            return httpResult.getData();
        }
    }

    /**
     * 用于统一处理线程和类型转换
     */
    private class LiftAll<T> implements Observable.Transformer<HttpResult<T>, T>{
        @Override
        public Observable<T> call(Observable<HttpResult<T>> httpResultFuncObservable) {

            return httpResultFuncObservable
                    .subscribeOn(Schedulers.io())
                    .doOnSubscribe(new Action0() {
                        @Override
                        public void call() {

                        }
                    })
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .map(new HttpResultFunc<T>());
        }
    }

    public void getContact(String imi, String phone, String ver, Subscriber<ComEntity> subscriber){
        serverAPI.GetNotice(imi, phone, ver)
                .compose(liftAll)
                .subscribe(subscriber);
    }

    public void getConList(String id, Subscriber<List<ComBean>> subscriber){
        serverAPI.getCom(id)
                .compose(liftAll)
                .filter(new Func1() {
                    @Override
                    public Object call(Object o) {
                        return null;
                    }
                })
                .subscribe(subscriber);
    }
}
