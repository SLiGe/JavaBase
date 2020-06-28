package com.spring.bean.ioc.condition;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

/**
 * @author zJiaLi
 * @since 2020-06-28 21:43
 */
public class CmdCondition {

    public static class WindowsCmdCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, @NotNull AnnotatedTypeMetadata metadata) {
            return Objects.requireNonNull(context.getEnvironment().getProperty("os.name")).toLowerCase().contains("windows");
        }
    }

    public static class LinuxCmdCondition implements Condition {
        @Override
        public boolean matches(@NotNull ConditionContext context, @NotNull AnnotatedTypeMetadata metadata) {
            return Objects.requireNonNull(context.getEnvironment().getProperty("os.name")).toLowerCase().contains("linux");
        }
    }
}
