package com.love2code.springdemo;

import com.love2code.spring.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    private HappyFortuneService service;

    @Autowired
    public TrackCoach(HappyFortuneService service) {
        this.service = service;
    }

    @Override
    public String getDailyFortune() {
        return service.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Don't give up!";
    }
}
