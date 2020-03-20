package com.java.function;

import com.java.function.interfaces.LogBuilderInterface;

/**
 * @author zJiaLi
 * @since 2020-03-19 23:10
 */
public class LoggerMain {

    public static void showLog(int level, LogBuilderInterface builderInterface) {
        if (level == 1) {
            System.out.println(builderInterface.builderMessage("hh"));
        }
    }

    public static void main(String[] args) {
        //Lambda延迟执行
        String msg1 = "show ";
        String msg2 = "i ";
        showLog(1, (ms) -> msg1 + msg2 + ms + "Java");
    }
}
