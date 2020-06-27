package com.spring.bean.ioc.factory;

import okhttp3.OkHttpClient;

/**
 *  实例工厂
 * @author zJiaLi
 * @since 2020-06-27 17:30
 */
public class OkHttpExampleFactory {

    private OkHttpClient okHttpClient;

    public OkHttpClient getInstance(){
        if (okHttpClient == null){
            return new OkHttpClient.Builder().build();
        }
        return okHttpClient;
    }
}
