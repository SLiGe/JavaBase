package com.java.mode.observer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 观察者模式:用于事件监听，通知发布等场景，可以确保观察者在不使用轮询监控下，及时收到相关消息和事件
 * 角色->{
 *     1.主题接口：指被观察的对象，当其状态发生改变或某事件发生时，它会将这个变化通知观察者，他维护了观察者所需要依赖的状态
 *     2.具体接口：具体主题实现了主题接口中的方法。如新增观察者，删除观察者和通知观察者，其内部维护了一个观察者列表
 *     3.观察者接口：观察者接口定义了观察者的基本方法，当依赖状态发生改变时，主题接口就会调用观察者的update()方法
 *     4.具体观察者：实现了观察者接口的update()，具体处理当被观察者状态改变或者某一事件发生时的业务逻辑。
 * }
 * <p>
 * 具体观察者
 *
 * @author : Gary
 * @since 2019/11/08 16:44
 */
public class BtnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click---!!!");
    }

    public static void main(String[] args) {
        JFrame p = new JFrame();
        //新建具体主题
        JButton btn = new JButton("Click this");
        //在具体主题中，加入观察者
        btn.addActionListener(new BtnListener());
        p.add(btn);
        p.pack();
        p.setVisible(true);
    }
}
