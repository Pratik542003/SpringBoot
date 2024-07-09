package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
//java class that has related advices
@Component
public class MyDemoLoggingAspect {
    //this is where we add all of our related advices
    //for more precise execution we need to give className
    //access modifier is optional

    @Before("execution(* com.spring.aop.dao.*.*())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n====> Executing @Before advice on addAccount()");
    }



}
