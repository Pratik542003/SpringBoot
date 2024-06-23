package com.spring.springcoredemo.rest;

import com.spring.springcoredemo.comon.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //Create a constructor in your class for injections
    //define a private field for dependency
    private Coach myCoach;

    private Coach anotherCoach;


    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach theanotherCoach
                        ){

        System.out.println("In Constructor: "+getClass().getSimpleName());
        myCoach=theCoach;
        anotherCoach = theanotherCoach;
    }



    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/check")
    public String check(){
        return "Comparing beans : myCoach == anotherCoach, "+(myCoach==anotherCoach);
    }
}
