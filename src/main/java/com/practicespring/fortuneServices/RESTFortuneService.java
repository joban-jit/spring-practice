package com.practicespring.fortuneServices;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "RESTFortune: 200 is sight to see";
    }
}
