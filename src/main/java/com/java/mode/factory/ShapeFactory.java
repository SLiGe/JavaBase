package com.java.mode.factory;

import static java.lang.Class.forName;

/**
 * 对象工厂
 *
 * @author Gary
 * @since 2019/11/18 16:23
 */
public class ShapeFactory {

    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if ("CIRCLE".equalsIgnoreCase(shapeType)) {
            return new Circle();
        } else if ("SQUARE".equalsIgnoreCase(shapeType)) {
            return new Square();
        } else if ("RECTANGLE".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        }
        return null;
    }

    /**
     * 使用反射获取对象
     */
    public static Object getClass(Class<? extends Shape> clazz) {
        Object obj = null;
        try {
            obj = forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 反射获取Shape，无需强转
     */
    @SuppressWarnings(value = "unchecked")
    public static <T> T getShape(Class<? extends T> clazz) {
        T t = null;
        try {
            t = (T) forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> Object getObject(Class<T> clazz) {
        if (clazz == null) {
            return null;
        }
        Object instance = null;
        try {
            /*
             * 在Jdk9中使用:
             * clazz.getDeclaredConstructor().newInstance();*/
            instance = forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
