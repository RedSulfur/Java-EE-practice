package com.love2code.springdemo;

import com.love2code.spring.interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    @Override
    public String getDailyFortune() {
        return null;
    }

    @Override
    public String getDailyWorkout() {
        return "Don't give up!";
    }
}
