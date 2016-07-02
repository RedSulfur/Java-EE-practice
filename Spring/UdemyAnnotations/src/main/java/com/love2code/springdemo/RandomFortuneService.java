package com.love2code.springdemo;

import com.love2code.spring.interfaces.FortuneService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private Random random = new Random();

    private String[] fortunes = {
            "fortune1",
            "fortune2",
            "fortune3"
    };

    @Override
    public String getFortune() {

        int index = random.nextInt(fortunes.length);
        String theString = fortunes[index];
        return theString;
    }
}
