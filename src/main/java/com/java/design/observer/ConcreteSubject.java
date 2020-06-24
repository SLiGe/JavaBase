package com.java.design.observer;

import java.util.Vector;

/**
 * @author : Gary
 * @since 2019/11/08 17:03
 */
public class ConcreteSubject implements ISubject {

    Vector<IObserver> observers = new Vector<>();

    @Override
    public void attach(IObserver observer) {
        observers.addElement(observer);
    }

    @Override
    public void delete(IObserver observer) {
        observers.removeElement(observer);
    }

    @Override
    public void inform() {

    }
}
