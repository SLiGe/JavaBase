package com.lambda.method.reference;

/**
 * 构造函数引用
 * @author zJiaLi
 * @since 2020-07-18 20:57
 */
public class ConstructorReference {
    public static void main(String[] args) {
        MakeNoArgs makeNoArgs = Dog::new;
        Make1Args make1Args = Dog::new;
        Make2Args make2Args = Dog::new;
        Dog d1 = makeNoArgs.make();
        Dog d2 = make1Args.make("Jack");
        Dog d3 = make2Args.make(1, "Jack");
    }
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Args {
    Dog make(String name);
}

interface Make2Args {
    Dog make(int age, String name);
}

class Dog {
    int age;
    String name;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
