package com.spring.springcoredemo.comon;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class BaseBallCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Spend 30 mins in batting practice";
    }
}
