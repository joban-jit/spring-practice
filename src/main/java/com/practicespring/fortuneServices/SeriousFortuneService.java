package com.practicespring.fortuneServices;

public class SeriousFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "All you got is you";
    }
}
