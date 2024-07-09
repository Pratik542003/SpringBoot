package com.spring.aop.dao;

import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;


@Repository
public class MembershipDAOImpl implements MemberShipDAO {

    @Override
    public boolean addAccount() {
        System.out.println(getClass()+" Doing my db work:Adding a membership account");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println("Having a good night sleep");
    }
}
