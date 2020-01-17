package com.duteliang.webbase.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2020-1-16 15:31
 */
@Aspect
@Component
public class AopTestAspect {

    @Pointcut("execution(public * com.duteliang.webbase.aop.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("我是AOP 前置通知！");
    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("我是AOP 后置通知！");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void doAfterReturning(JoinPoint joinPoint,String result){
        System.out.println("我是AOP 正常返回通知！返回值："+result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint,Exception e) {
        System.out.println("我是AOP 异常返回通知！异常:"+e.getMessage());
    }

    @Around(value = "pointCut()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("我是环绕AOP 前置通知！");
        Object proceed;
        try {
            proceed = pjp.proceed();
        }catch (Throwable t){
            System.out.println("我是环绕AOP 异常返回通知！异常:"+t.getMessage());
            throw t;
        } finally {
            System.out.println("我是环绕AOP 后置通知！");
        }
        System.out.println("我是环绕AOP 正常返回通知！返回值："+proceed);
        return proceed;
    }
}
