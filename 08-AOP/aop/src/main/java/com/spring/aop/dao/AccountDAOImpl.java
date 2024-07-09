package com.spring.aop.dao;

import com.spring.aop.Account;
import org.springframework.stereotype.Repository;


@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount1() {
        System.out.println("Adding second Account");
    }

    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass()+" Doing my db work");
    }
}
