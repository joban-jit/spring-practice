package com.practicespring.model;

import com.practicespring.fortuneServices.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("cricketCoach")
public class CricketCoach implements Coach{

    private FortuneService fortuneService;


    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public void setEmail(String email) {
        System.out.println("CricketCoach: inside setter method - setEmail");
        this.email = email;
    }

    public void setTeam(String team) {
        System.out.println("CricketCoach: inside setter method - setTeam");
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 mins.";
    }
    @Override
    public String getDailyFortune() {
        return "Cricket coach says: "+fortuneService.getFortune();
    }

    @Autowired
    @Qualifier("happyFortuneService")
    public void customNameGivenInsteadOfSetterMethod(FortuneService fortuneService) {
        System.out.println("Inside setter method of Cricket coach");
        this.fortuneService = fortuneService;
    }
}
