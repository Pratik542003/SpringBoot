package com.spring.springcoredemo.comon;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    public BaseBallCoach(){
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Spend 30 mins in batting practice";
    }
}
