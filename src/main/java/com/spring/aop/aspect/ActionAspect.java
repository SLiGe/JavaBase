package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author zJiaLi
 * @since 2020-06-30 08:02
 */
@Component
@Aspect
public class ActionAspect {

    /**
     * 统一定义切点
     */
    @Pointcut(value = "@annotation(Action)")
    public void pointcut() {
    }

    /**
     * @param joinPoint 包含了目标方法的关键信息
     * @Before 注解表示这是一个前置通知, 即在目标方法执行前进行执行, 注解中, 需要填入切点
     */
    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName() + "开始执行...");
    }

    /**
     * @param joinPoint 包含了目标方法的关键信息
     * @After 表示后置通知, 即在目标方法执行后执行
     */
    @After(value = "@annotation(Action)")
    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName() + "执行结束...");
    }

    /**
     * @param joinPoint 包含了目标方法的关键信息
     * @param o         目标方法返回值,拦截所有的返回指可写为Object(包括void),可指定类型,但必须与目标方法返回值相同
     * @AferReturning 注解表示返回通知, 即目标有返回值的时候才会触发, returning属性表示目标方法返回值的变量名
     */
    @AfterReturning(value = "@annotation(Action)", returning = "o")
    public void returning(JoinPoint joinPoint, Object o) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName() + " 返回值: " + o);
    }

    /**
     * @param joinPoint 包含了目标方法的关键信息
     * @param e         目标方法抛出的异常,这个参数必须是目标方法所抛出的异常或者所抛出异常的父类,如果想拦截所有异常,则写Exception
     * @AfterThrowing 表示异常通知
     */
    @AfterThrowing(value = "@annotation(Action)", throwing = "e")
    public void throwing(JoinPoint joinPoint, Exception e) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName() + " 遇到异常: " + e.getMessage());
    }

    /**
     * 环绕通知可以实现以上的四个通知功能,核心如在这里反射执行方法
     *
     * @param pjp 执行参数
     * @return 返回值和目标方法相匹配
     */
    @Around(value = "@annotation(Action)")
    public Object around(ProceedingJoinPoint pjp) {
        Object proceed = null;
        try {
            Object[] args = pjp.getArgs();
            // Arrays.fill(args, 2);
            //相当于method.invoke(), 前后都可添加代码,相当于前置/后置通知
            proceed = pjp.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
