package com.spring.springcoredemo.config;

import com.spring.springcoredemo.comon.Coach;
import com.spring.springcoredemo.comon.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
