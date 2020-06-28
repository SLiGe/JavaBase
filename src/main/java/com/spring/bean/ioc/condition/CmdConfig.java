package com.spring.bean.ioc.condition;

import com.spring.bean.ioc.condition.impl.LinuxCmd;
import com.spring.bean.ioc.condition.impl.WindowsCmd;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author zJiaLi
 * @since 2020-06-28 21:46
 */
@Configuration
public class CmdConfig {

    @Bean("showCmd")
    //条件注解,bean的名字一定要相同
    @Conditional(CmdCondition.WindowsCmdCondition.class)
    public ShowCmd windowsCmd(){
        return new WindowsCmd();
    }

    @Bean("showCmd")
    @Conditional(CmdCondition.LinuxCmdCondition.class)
    public ShowCmd linuxCmd(){
        return new LinuxCmd();
    }

}
