package com.practicespring;

public class TrackCoach implements Coach{

    // define a private field for the dependency
    private FortuneService fortuneService;

    // define a constructor for dependency injection
    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Run 10 rounds of the track";
    }

    @Override
    public String getDailyFortune() {
        // use my fortuneService to get a fortune
        return "Track coach says: "+fortuneService.getFortune();
    }
}
