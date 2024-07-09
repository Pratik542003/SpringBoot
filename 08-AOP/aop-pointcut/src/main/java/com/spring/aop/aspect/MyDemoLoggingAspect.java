package com.spring.aop.aspect;

import com.spring.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterReturning(
            pointcut = "execution(* com.spring.aop.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningAdvice(JoinPoint theJoinPoint, List<Account> result){
        String method= theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterReturning on method: "+method);
        System.out.println("\n====>>> result: "+result);

        convertAccountNamestoUpperCase(result);
        System.out.println("\n====>>> result: "+result);

    }

    private void convertAccountNamestoUpperCase(List<Account> result) {
        for(Account temp:result){
            String theUpperName = temp.getName().toUpperCase();
            temp.setName(theUpperName);
        }
    }


    @Before("com.spring.aop.aspect.AopExpression.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n====> Executing @Before advice on method");

        MethodSignature methodSignature =(MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method:"+methodSignature);

        Object[] args = theJoinPoint.getArgs();

        for(Object tempArg:args){
            System.out.println(tempArg);
            if(tempArg instanceof Account){
                //DOWNCAST IT
                Account theAccount = (Account) tempArg;
                System.out.println("account name: "+theAccount.getName());

            }
        }
    }

}



