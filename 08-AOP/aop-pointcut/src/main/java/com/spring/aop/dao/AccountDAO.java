package com.spring.aop.dao;

import com.spring.aop.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts();


    void addAccount1();
    void addAccount(Account theAccount,boolean vipFlag);

    public String getName();

    public void setName(String name);

    public String getServiceCode();


    public void setServiceCode(String serviceCode) ;

}
