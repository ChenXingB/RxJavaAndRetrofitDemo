package com.example.admin.rxjavaandretrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onClick() {
//        GetNoce();
        getComList();
    }


    public void GetNoce() {

        Subscriber<ComEntity> subscriber = new Subscriber<ComEntity>() {

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCompleted() {
                tv.setText(tv.getText().toString() + "" +  "onCompleted222" );
            }

            @Override
            public void onError(Throwable e) {
                tv.setText(tv.getText().toString() + "error：" +  e.getMessage() );
            }

            @Override
            public void onNext(ComEntity comEntity) {
                tv.setText(tv.getText().toString() + "" + comEntity.getName());
            }
        };

        HttpMethods.getInstance().getContact("2136456465465", "15859209340", "4d5s6fas4f56df465sd4", subscriber);
    }


    public void getComList(){
        Subscriber<List<ComBean>> subscriber = new Subscriber<List<ComBean>>() {
            @Override
            public void onCompleted() {
                tv.setText(tv.getText().toString() + "" +  "onCompleted222" );
            }


            @Override
            public void onError(Throwable e) {
                tv.setText(tv.getText().toString() + "error:" +  e.getMessage() );
            }

            @Override
            public void onNext(List<ComBean> comBeen) {
                tv.setText(tv.getText().toString() + "size = " + comBeen.size());
            }
        };

        HttpMethods.getInstance().getConList("4395", subscriber);
    }

}
