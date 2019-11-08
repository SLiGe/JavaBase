package com.java.mode.observer;

import java.awt.*;

/**
 * 观察者接口
 *
 * @author : Gary
 * @since 2019/11/08 16:59
 */
public interface IObserver {
    /**
     * 更新观察者
     */
    void update(Event event);
}
