package com.java.design.proxy.dynamic;

import com.java.design.proxy.DBQuery;
import com.java.design.proxy.IDBQuery;
import javassist.*;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;

/**
 * 使用Javassist创建动态代理对象
 * 与静态代理相比，动态代理可以很大幅度减少代码行数，并提升系统灵活性
 *
 * @author : Gary
 * @since 2019/11/08 10:09
 */
public class JavassistDynDbQueryHandler implements MethodHandler {

    private IDBQuery real = null;

    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
        if (real == null)
            real = new DBQuery();
        return real.request();
    }

    /**
     * 一般Javassist创建代理方法
     */
    public static IDBQuery createJavassistDynProxy() throws IllegalAccessException, InstantiationException {
        ProxyFactory proxyFactory = new ProxyFactory();
        //指定接口
        proxyFactory.setInterfaces(new Class[]{IDBQuery.class});
        Class proxyClass = proxyFactory.createClass();
        IDBQuery javassistProxy = (IDBQuery) proxyClass.newInstance();
        //设置Handler处理器
        ((ProxyObject) javassistProxy).setHandler(new JavassistDynDbQueryHandler());
        return javassistProxy;
    }

    /**
     * 使用动态Java代码创建代理-> 通过Java代码生成字节码
     */
    public static IDBQuery createJavassistBytecodeDynamicProxy() throws Exception {
        ClassPool classPool = new ClassPool(true);
        //定义类名
        CtClass ctClass = classPool.makeClass(IDBQuery.class.getName() + "JavassistBytecodeProxy");
        //需要实现的接口
        ctClass.addInterface(classPool.get(IDBQuery.class.getName()));
        //添加构造函数
        ctClass.addConstructor(CtNewConstructor.defaultConstructor(ctClass));
        //添加类的字段信息,使用动态Java代码
        ctClass.addField(CtField.make("public " + IDBQuery.class.getName() + " real=null;", ctClass));
        //真实主题
        String dbQueryName = DBQuery.class.getName();
        //添加方法，使用动态Java代码指定内部逻辑
        ctClass.addMethod(CtNewMethod.make("public String request(){if (real==null)real = new " + dbQueryName + "();" +
                "return real.request();}", ctClass));
        //生成动态类
        Class pc = ctClass.toClass();
        //生成动态类的实例
        IDBQuery bytecodeProxy = (IDBQuery) pc.newInstance();
        return bytecodeProxy;
    }
}
