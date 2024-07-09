package com.spring.aop.dao;

import com.spring.aop.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AccountDAOImpl implements AccountDAO{
    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();
        Account temp1 = new Account("Pratik","Platinum");
        Account temp2 = new Account("Dhanraj","Platinum");
        Account temp3 = new Account("Prashant","Platinum");

        myAccounts.add(temp1);

        myAccounts.add(temp2);
        myAccounts.add(temp3);
        return  myAccounts;
    }

    @Override
    public void addAccount1() {
        System.out.println("Adding second Account");
    }

    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass()+" Doing my db work");
    }

    public String getName() {
        System.out.println(getClass()+ " in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+ " in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+ " in getServiceCode()");
        return serviceCode;
    }


    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+ " in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
