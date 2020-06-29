package com.java.map;

import java.util.HashMap;

/**
 * @author zJiaLi
 * @since 2020-06-29 09:53
 */
public class MapMain {

    public static void main(String[] args) {
        putSameEntry();
    }

    public static void putSameEntry(){
        //initialCapacity = (存储元素个数/负载因子[0.75])+1
        HashMap<String,String> map = new HashMap<>(2);
        map.put("357078415","Admin");
        System.out.println(map.size());
        map.put("357078415","Root");
        System.out.println(map.size());
    }
}
