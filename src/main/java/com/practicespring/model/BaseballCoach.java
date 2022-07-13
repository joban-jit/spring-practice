package com.practicespring.model;

import com.practicespring.fortuneServices.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BaseballCoach implements Coach{

    // define a private field for the dependency
    private FortuneService fortuneService;

    // define a constructor for dependency injection
    @Autowired
    public BaseballCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Dunk 100 ball in basket";
    }

    @Override
    public String getDailyFortune() {
        // use my fortuneService to get a fortune
        return "Baseball coach says: "+fortuneService.getFortune();
    }
}