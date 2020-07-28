package com.lambda.method.reference;

import java.util.function.Function;
import java.util.function.Supplier;

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
        Supplier<Dog> su1 = Dog::new;
        Dog dog = su1.get();
        System.out.println(dog);
        Function<String,Dog> fu1 = Dog::new;
        Dog lucy = fu1.apply("Lucy");
        System.out.println(lucy);
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

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
