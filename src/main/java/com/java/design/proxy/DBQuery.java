package com.java.design.proxy;

/**
 * 真实主题：真正实现业务逻辑的类
 *
 * @author : Gary
 * @since 2019/11/07 16:06
 */
public class DBQuery implements IDBQuery {

    /**
     * DBQuery为重量级对象，构造会比较慢
     */
    public DBQuery() {
        try {
            //可能包含一系列耗时操作，如数据库连接
            Thread.sleep(1000);
            System.out.println("DBQuery is create!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        return "request for string";
    }
}
