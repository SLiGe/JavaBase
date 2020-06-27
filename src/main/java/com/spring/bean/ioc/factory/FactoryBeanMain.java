package com.spring.bean.ioc.factory;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Objects;

/**
 * 工厂方法获取Bean实例
 *
 * @author zJiaLi
 * @since 2020-06-27 15:18
 */
@Slf4j
public class FactoryBeanMain {

    private static final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");

    public static void main(String[] args) {
        getExampleFactoryBean();
        getStaticFactoryBean();
    }

    /**
     * 实例工厂方法获取Bean
     */
    private static void getExampleFactoryBean() {
        System.out.println("实例工厂方法获取Bean");
        OkHttpClient okHttpClient = ctx.getBean("exampleOkHttpClient", OkHttpClient.class);
        Request request = new Request.Builder().url("https://www.bilibili.com").get().build();
        Call call = okHttpClient.newCall(request);
        try (Response execute = call.execute()) {
            ResponseBody body = execute.body();
            System.out.println(Objects.requireNonNull(body).string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 静态工厂方法获取bean
     */
    public static void getStaticFactoryBean() {
        System.out.println("静态工厂方法获取bean");
        OkHttpClient okHttpClient = ctx.getBean("okHttpClient", OkHttpClient.class);
        Request request = new Request.Builder().url("https://www.baidu.com").get().build();
        Call call = okHttpClient.newCall(request);
        try (Response execute = call.execute()) {
            ResponseBody body = execute.body();
            System.out.println(Objects.requireNonNull(body).string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
