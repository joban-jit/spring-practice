package com.practicespring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        // load the spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Coach trackCoach = context.getBean("trackCoach", Coach.class);
        Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
        Coach cricketCoach = context.getBean("cricketCoach", Coach.class);
        // as Coach doesn't have getEmail() and getTeam() methods in it so we need to get the instance
        // of CricketCoach class not Coach
        CricketCoach cricketCoach2 = context.getBean("cricketCoach", CricketCoach.class);

        // call methods on the bean
        System.out.println(trackCoach.getDailyWorkout());
        System.out.println(baseballCoach.getDailyWorkout());
        System.out.println(cricketCoach.getDailyWorkout());

        // call new methods which uses dependency
        System.out.println(trackCoach.getDailyFortune());
        System.out.println(baseballCoach.getDailyFortune());
        System.out.println(cricketCoach.getDailyFortune());

        // call new methods to get the literal values
        System.out.println(cricketCoach2.getTeam());
        System.out.println(cricketCoach2.getEmail());

        // there are two statements where we are creating bean of "cricketCoach" with different instance
        // type but Spring will only create one singleton bean and on 2nd call it will return instance which is
        // already created
        // as we can see below statment will return true
        System.out.println(cricketCoach==cricketCoach2); // true

        //close the context
        context.close();
    }
}

