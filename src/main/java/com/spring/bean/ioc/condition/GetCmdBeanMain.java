package com.spring.bean.ioc.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zJiaLi
 * @since 2020-06-28 21:48
 */
public class GetCmdBeanMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext act = new AnnotationConfigApplicationContext(CmdConfig.class);
        ShowCmd showCmd = (ShowCmd) act.getBean("showCmd");
        System.out.println("showCmd ==== " + showCmd.showCmd());
    }

}
