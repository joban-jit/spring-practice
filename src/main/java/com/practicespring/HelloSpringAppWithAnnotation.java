package com.practicespring;

import com.practicespring.model.Coach;
import com.practicespring.model.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringAppWithAnnotation {
    public static void main(String[] args) {
        // load the spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "applicationContext.xml");

        // retrieve bean from spring container
        Coach trackCoach = context.getBean("trackCoach", Coach.class);
        Coach anotherTrackCoach = context.getBean("trackCoach", Coach.class);

        Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
        Coach antherBaseballCoach = context.getBean("baseballCoach", Coach.class);
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

        // by default it is Singleton.

        // there are two statements where we are creating bean of "cricketCoach" with different instance
        // type but Spring will only create one singleton bean and on 2nd call it will return instance which is
        // already created
        // as we can see below statement will return true
        System.out.println(cricketCoach==cricketCoach2); // true


        // another example for singleton
        System.out.println(trackCoach==anotherTrackCoach); //true
        System.out.println("Memory location for trackCoach: "+trackCoach); //com.practicespring.TrackCoach@557caf28
        System.out.println("Memory location for anotherTrackCoach: "+anotherTrackCoach);//com.practicespring.TrackCoach@557caf28

        // example for prototype scope:
        System.out.println(baseballCoach==antherBaseballCoach); //false
        System.out.println("Memory location for baseballCoach: "+baseballCoach); //com.practicespring.BaseballCoach@408d971b
        System.out.println("Memory location for anotherBaseballCoach: "+antherBaseballCoach);//com.practicespring.BaseballCoach@6c6cb480



        //close the context
        context.close();
    }
}

