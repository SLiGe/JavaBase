package com.lambda.method.reference;

/**
 * 方法引用
 *
 * @author zJiaLi
 * @since 2020-07-17 23:06
 */

public class MethodReferences {

    static void hello(String msg) {
        System.out.println("MethodReferences 's static method: hello ,arg: " + msg);
    }

    static class Description {
        String about;

        public Description(String about) {
            this.about = about;
        }

        void help(String msg) {
            System.out.println(msg + about);
        }
    }

    static class Helper {
        static void assist(String msg) {
            System.out.println("MethodReferences 's static class Helper 's method assist");
        }
    }

    public static void main(String[] args) {
        Describe describe = new Describe();
        //参数类型一致,返回值类型相同
        //对象名 : 实例
        ShowApi show = describe::show;
        ShowApi show2 = describe::call;
        show.call("instance reference");
        //类名 : 静态
        show = MethodReferences::hello;
        show.call("static reference");

        show = new Description("Description")::help;
        show.call("constructor");

        show = MethodReferences.Helper::assist;
        show.call("static class");

    }

}

interface ShowApi {
    void call(String s);
}

class Describe {
    public void show(String s) {
        System.out.println("Describe 's show: " + s);
    }

    public void call(String msg) {
        System.out.println("Describe 's call: " + msg);
    }
}


