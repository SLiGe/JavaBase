package com.lambda.method.reference;

/**
 * 未绑定的方法与多参数的结合运用
 * 如果你的函数式接口中的方法有多个参数，就以第一个参数接受this的模式来处理
 *
 * @author zJiaLi
 * @since 2020-07-18 20:44
 */
public class MultiUnbound {
    public static void main(String[] args) {
        TwoArgs twoArgs = This::two;
        ThreeArgs threeArgs = This::three;
        FourArgs fourArgs = This::four;
        This his = new This();
        twoArgs.two(his, 1, 1);
        threeArgs.three(his, 1, 2, 3);
        fourArgs.four(his, 1, 2, 3, (short) 4);
    }
}

class This {
    void two(int i, double d) {
    }

    void three(int i, double d, float f) {
    }

    void four(int i, double d, float f, short s) {
    }
}

interface TwoArgs {
    void two(This t, int i, double d);
}

interface ThreeArgs {
    void three(This t, int i, double d, float f);
}

interface FourArgs {
    void four(This t, int i, double d, float f, short s);
}