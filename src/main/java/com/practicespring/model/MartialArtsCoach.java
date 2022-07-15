package com.practicespring.model;

import com.practicespring.fortuneServices.FortuneService;
// no Component annotation
public class MartialArtsCoach implements Coach{

    // No autowired annotation
    private FortuneService fortuneService;

    public MartialArtsCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Break a log with punches";
    }

    @Override
    public String getDailyFortune() {
        return "MartialArts Coach says: "+fortuneService.getFortune();
    }
}
