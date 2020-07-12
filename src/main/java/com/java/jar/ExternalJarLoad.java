package com.java.jar;

import cn.hutool.core.lang.JarClassLoader;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载外部Jar包
 *
 * @author zJiaLi
 * @since 2020-07-12 09:55
 */
public class ExternalJarLoad {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        //加载外部Jar
        JarClassLoader jarClassLoader = JarClassLoader.load(new File("D:\\DevTool\\Maven\\repository\\com\\cuslink\\health-common\\1.0-SNAPSHOT\\health-common-1.0-SNAPSHOT.jar"));
        Class<?> aClass = jarClassLoader.loadClass("com.cuslink.common.util.JsonUtils");
        //获取Bean的名称
        String uncapitalizeClassName = StringUtils.uncapitalize(aClass.getSimpleName());
        //构建Spring Bean
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(aClass);
        AbstractBeanDefinition rawBeanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
        //单例Bean
        rawBeanDefinition.setScope("singleton");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) ctx.getBeanFactory();
        beanFactory.registerBeanDefinition(uncapitalizeClassName, rawBeanDefinition);
        Object jsonUtils = ctx.getBean(uncapitalizeClassName, aClass);
        Map<String, String> map = new HashMap<>();
        map.put("name", "Jack");
        Method[] declaredMethods = aClass.getDeclaredMethods();
        Object invoke = declaredMethods[0].invoke(jsonUtils, map);
        System.out.println(invoke);
        Arrays.stream(declaredMethods).forEach(e -> System.out.println(e.getName()));
    }
}
