package com.lambda.method.reference;

import java.util.function.BiFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/**
 * @author zJiaLi
 * @since 2020-07-22 20:03
 */
public class MethodReference2 {


    public static void main(String[] args) {
        BigDog bigDog = new BigDog();
        UnaryOperator<Integer> uo = bigDog::eat;
        uo.apply(4);
        IntUnaryOperator iuo = bigDog::eat;
        //此处不会发生空指针异常,因为传递的是bigDog的值,在Lambda中已经有了bigDog的引用
        bigDog = null;
        iuo.applyAsInt(2);
        BiFunction<BigDog, Integer, Integer> bf = BigDog::eat;
        bf.apply(bigDog, 3);
    }


}

class BigDog {
    private final String name = "二哈";

    private int food = 10;

    /**
     * 成员方法,默认加上this
     */
    public int eat(BigDog this, int num) {
        System.out.println("吃了" + num + "斤狗粮");
        this.food -= num;
        return this.food;
    }

}
