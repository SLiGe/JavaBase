package com.java.thread_learn.singleton.singleton3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gary
 * @since 2019/12/10 10:39
 */
public class MyObject {
    public enum MyObjectEnum {
        map;
        private Map hashMap;

        MyObjectEnum() {
            hashMap = new HashMap(){
                {
                    put(1,1);
                }
            };
        }

        public Map getHashMap() {
            return hashMap;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new MyThread().start();
        }
    }
    public static Map getMap() {
        return MyObjectEnum.map.getHashMap();
    }

   static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(MyObject.getMap().hashCode());
            }
        }
    }
}
