package com.love2code.springdemo;

import com.love2code.spring.interfaces.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return null;
    }
}
