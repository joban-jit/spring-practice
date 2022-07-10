package com.practicespring;

public class BaseballCoach implements Coach{

    // define a private field for the dependency
    private FortuneService fortuneService;

    // define a constructor for dependency injection
    public BaseballCoach(FortuneService fortuneService) {
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