package com.love2code.springdemo;

import com.love2code.spring.interfaces.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "This is a daily fortune!";
    }
}
