package com.spring.springcoredemo.comon;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }
    //Define init method
    @PostConstruct
    public void postcon(){
        System.out.println("in PosstCon"+getClass().getSimpleName());
    }
    @PreDestroy
    public void predestroy(){
        System.out.println("in PreDestroy"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 minutes";
    }

}
