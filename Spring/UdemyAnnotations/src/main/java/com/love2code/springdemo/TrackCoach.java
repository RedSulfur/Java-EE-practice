package com.love2code.springdemo;

import com.love2code.spring.interfaces.Coach;
import com.love2code.spring.interfaces.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

    /**
     * Field injection
     */
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService service;

    public TrackCoach() {
        System.out.println("Inside the default constructor!");
    }

    /**
     * Constructor injection
     */
    /*@Autowired
    public TrackCoach(HappyFortuneService service) {
        this.service = service;
    }*/

    /**
     * Setter injection
     */
    /*
    @Autowired
    public void setService(HappyFortuneService service) {
        System.out.println("inside setService() method!");
        this.service = service;
    }*/

    @Override
    public String getDailyFortune() {
        return service.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Don't give up!";
    }
}
