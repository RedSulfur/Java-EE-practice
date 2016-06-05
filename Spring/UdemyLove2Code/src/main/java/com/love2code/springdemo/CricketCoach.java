package com.love2code.springdemo;


import com.love2code.spring.interfaces.Coach;
import com.love2code.spring.interfaces.FortuneService;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;
    private String emailAddress;
    private String team;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCoach: inside setter method - setEmailAddress");
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setter method - setTeam");
        this.team = team;
    }

    public CricketCoach() {
        System.out.println("CricketCoach: inside non-arg constructor");
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach: inside setter method - setFortuneService");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyFortune() {
        return "\nCricketCoach part \n\n" + fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Do some weird stuff";
    }
}
