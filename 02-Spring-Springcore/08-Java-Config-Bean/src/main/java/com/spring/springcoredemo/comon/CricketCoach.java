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

    @Override
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 minutes";
    }

}
