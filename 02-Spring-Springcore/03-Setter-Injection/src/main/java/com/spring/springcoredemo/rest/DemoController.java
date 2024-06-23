package com.spring.springcoredemo.rest;

import com.spring.springcoredemo.comon.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //Create a constructor in your class for injections
    //define a private field for dependency
    private Coach myCoach;

    @Autowired
    public void setCoach(Coach theCoach){
        myCoach=theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
