package com.spring.bean.ioc.condition.impl;

import com.spring.bean.ioc.condition.ShowCmd;

/**
 * @author zJiaLi
 * @since 2020-06-28 21:42
 */
public class WindowsCmd implements ShowCmd {
    @Override
    public String showCmd() {
        return "dir";
    }
}
