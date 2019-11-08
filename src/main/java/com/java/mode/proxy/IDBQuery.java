package com.java.mode.proxy;

/**
 * 代理模式
 * {
 * 1.安全：屏蔽客户端直接访问真实对象
 * 2.远程调用：使用代理类处理远程方法调用的技术细节
 * 3.系统性能：对真实对象进行封装，从而达到延迟加载，提升系统性能
 * }
 * 主题接口：定义代理类和真实主题的公共对外方法，也是代理类代理真是主题的方法
 * <p>
 * 本次事例为使用代理模式实现延迟加载，提升系统性能和反应速度
 * </p>
 *
 * @author : Gary
 * @since 2019/11/07 15:36
 */
public interface IDBQuery {

    String request();
}
