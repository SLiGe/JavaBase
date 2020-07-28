package com.lambda.type;

/**
 * 类型推断
 *
 * @author zJiaLi
 * @since 2020-07-22 22:23
 */
public class TypeDemo {

    public static void main(String[] args) {
        IMath iMath = (x, y) -> x + y;

        IMath[] iMath2 = {(x, y) -> x + y};

        //强转
        Object iMath3 = (IMath) (x, y) -> x + y;

        IMath iMath4 = gen();

        TypeDemo typeDemo = new TypeDemo();
        //当具有二义性时,使用强转来确定对应的接口
        typeDemo.test((IMath) (x, y) -> x + y);
    }

    public static IMath gen() {
        return (x, y) -> x + y;
    }

    public void test(IMath math) {

    }

    public void test(IMath2 math) {

    }
}

interface IMath {
    int add(int x, int y);
}

interface IMath2 {
    int add(int x, int y);
}
