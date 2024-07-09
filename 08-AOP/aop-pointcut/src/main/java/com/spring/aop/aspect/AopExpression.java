package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpression {
    @Pointcut("execution(* com.spring.aop.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.spring.aop.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.spring.aop.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}

}
