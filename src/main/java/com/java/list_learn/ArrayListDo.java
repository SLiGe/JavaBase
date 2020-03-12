package com.java.list_learn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Gary
 * @since 2019/11/25 10:22
 */
public class ArrayListDo {

    transient Object[] ts;

    /**
     * 测试数组增量
     * 数组的扩容会导致整个数组进行一次内存复制
     * 指定ArrayList容量大小能对其性能有较大的提升
     */
    @Test
    public void testArrays() {
        ArrayListDo listDo = new ArrayListDo();
        listDo.ts = new Object[]{1, 2, 3};
        listDo.generateArray(4);
        listDo.generateArray(5);
        List<Object> objects = Arrays.asList(listDo.ts);
        objects.forEach(System.out::println);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        Timestamp timestamp = Timestamp.valueOf(sdf.format(date));
        System.out.println(timestamp);
    }

    @Test
    public void forList() {
        List<A> list = new ArrayList<A>() {{
            add(new A("1",2));
            add(new A("2",3));
        }};
        /*for (A s : list) {
            list.remove(s);
            s = new A("4",5);
        }*/
       // list.forEach(System.out::println);
        list.forEach(a -> {
            if (a.getA().equals("1")){
                return;
            }
            System.out.println(a);
        });
    }

    @ToString
    @AllArgsConstructor
    @Data
    static
    class A {
        private String a;
        private int b;

    }

    private <T> void generateArray(T t) {
        int size = ts.length; //3
        ensureCapacity(size + 1); //4
        ts[size] = t;
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = ts.length;
        //如果容量不够，进行扩容
        if (minCapacity > oldCapacity) {
            // Object oldData[] = ts;
            //扩容到原始容量的1.5倍
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            //如果新容量小于最小需要的容量，则使用最小需要的容量大小
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            //进行扩容的数组复制
            ts = Arrays.copyOf(ts, newCapacity);
        }
    }
}
