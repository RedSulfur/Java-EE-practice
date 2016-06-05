package com.love2code.springdemo;


import com.love2code.spring.interfaces.FortuneService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {

        String s, result = "";
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("/home/sulfur/IdeaProjects/CodeWars/Spring/UdemyLove2Code/" +
                            "src/main/java/com/love2code/springdemo/HappyFortuneService.java"));

            while ((s = reader.readLine()) != null) {

                result += s + "\n";

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
