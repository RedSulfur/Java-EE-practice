package com.love2code.springdemo;


import com.love2code.spring.interfaces.Coach;
import com.love2code.spring.interfaces.FortuneService;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Do 40 chin-ups and its ok";
    }

}
