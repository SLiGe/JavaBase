package com.java.mode.observer;

/**
 * 主题接口
 *
 * @author : Gary
 * @since 2019/11/08 16:59
 */
public interface ISubject {
    /**
     * 添加观察者
     */
    void attach(IObserver observer);

    /**
     * 删除观察者
     */
    void delete(IObserver observer);

    /**
     * 通知观察者
     */
    void inform();
}
