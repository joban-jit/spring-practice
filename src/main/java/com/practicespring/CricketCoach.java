package com.practicespring;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;

    private String email;
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

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Inside setter method of Cricket coach");
        this.fortuneService = fortuneService;
    }
}
