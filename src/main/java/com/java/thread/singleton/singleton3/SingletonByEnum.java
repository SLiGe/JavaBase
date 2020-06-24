package com.java.thread.singleton.singleton3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gary
 * @since 2019/12/10 10:30
 */
public enum SingletonByEnum {
    map;
    private Map<String, String> hashMap;

    /*
     * 在使用枚举类时,构造方法会默认调用*/
    SingletonByEnum() {
        hashMap = new HashMap<>();
    }

    public Map<String, String> getHashMap() {
        return hashMap;
    }
}
