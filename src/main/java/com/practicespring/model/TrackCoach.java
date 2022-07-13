package com.practicespring.model;

import com.practicespring.fortuneServices.FortuneService;
import com.practicespring.model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("trackCoach")
public class TrackCoach implements Coach {

    // define a private field for the dependency
     // field injection
    @Autowired
    @Qualifier("RESTFortuneService")
    private FortuneService fortuneService;


    @Override
    public String getDailyWorkout() {
        return "Run 10 rounds of the track";
    }

    @Override
    public String getDailyFortune() {
        // use my fortuneService to get a fortune
        return "Track coach says: "+fortuneService.getFortune();
    }

    // adding a init method: custom code run after bean is created
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("TrackCoach: Inside doMyStartupStuff method");
    }

    // adding a destroy method: custom code run before bean is destroyed
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("TrackCoach: Inside doMyCleanupStuff method");
    }
}
