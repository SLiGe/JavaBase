package com.lambda.method.reference;

/**
 * 未绑定的方法引用
 *
 * @author zJiaLi
 * @since 2020-07-18 20:35
 */
public class UnboundMethodReference {
    public static void main(String[] args) {
        //  MakeString ms = X::fo;  X :: fo 不能在没有 X 对象的前提下调用 fo(),表示未绑定的方法引用，因为它尚未“绑定”到对象。

        /*使用未绑定的引用时，函数式方法的签名（接口中的单个方法）不再与方法引用的签名完全匹配。 原因是：你需要一个对象来调用方法
         * */
        TransformX tf = X::fo;

        X x = new X();

        System.out.println(x.fo());
        System.out.println(tf.transform(x));
    }
}

class X {
    //隐藏this参数
    String fo() {
        return "X::fo";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}
