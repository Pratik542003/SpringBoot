package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class yCloudLogAsyncAspect {
    @Before("com.spring.aop.aspect.AopExpression.forDaoPackageNoGetterSetter()er()")
    public void logtoCloudAsync() {
        System.out.println("\n====> Logging to Cloud in async");
    }
}
