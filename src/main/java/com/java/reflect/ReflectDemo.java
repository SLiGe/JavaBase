package com.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author zJiaLi
 * @since 2020-04-17 14:59
 */
public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<?> world = Class.forName("com.java.reflect.World");
        Field[] declaredFields = world.getDeclaredFields();
        resetStaticVar();
        declaredFields[0].setAccessible(true);
        declaredFields[0].set(world, "5");
        Field[] fields = world.getFields();
        System.out.println(declaredFields[0].get(world));
    }

    public static void resetStaticVar() throws IllegalAccessException, InstantiationException {
        Field[] fields = World.class.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                if (field.getType() == int.class) {
                    field.set(null, 0);
                } else if (field.getType() == float.class) {
                    field.set(null, 0.0);
                } else if (field.getType() == double.class) {
                    field.set(null, 0.0D);
                } else if (field.getType() == boolean.class) {
                    field.set(null, false);
                } else {
                    Object val = field.getType().newInstance();
                    field.set(null, val);
                }
            }
        }

    }
}
