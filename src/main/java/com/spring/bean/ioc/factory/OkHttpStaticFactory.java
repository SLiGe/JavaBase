package com.spring.bean.ioc.factory;

import okhttp3.OkHttpClient;

/**
 * @author zJiaLi
 * @since 2020-06-27 15:04
 */
public class OkHttpStaticFactory {

    private static OkHttpClient okHttpClient;

    public static synchronized OkHttpClient getInstance() {
        if (okHttpClient == null) {
            return new OkHttpClient.Builder().build();
        }
        return okHttpClient;
    }

}
