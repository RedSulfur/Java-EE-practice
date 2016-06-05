package com.love2code.springdemo;


import com.love2code.spring.interfaces.Coach;
import com.love2code.spring.interfaces.FortuneService;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyFortune() {
        return "\nTHIS is actually the different one\n\n" + fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Do 20 presses";
    }

    /**
     * You can add your own custom code during bean initialization
     * add init method
     */
    public void doStartupThing() {
        System.out.println("TrackCoach: inside method doStartupThing");
    }

    /**
     * You can add your own custom code during bean destruction
     * add destroy method
     */
    public void doCleanupMethod() {
        System.out.println("TrackCoach: inside method doStartupThing");
    }

}
