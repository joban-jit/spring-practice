package com.practicespring.config;


import com.practicespring.fortuneServices.SeriousFortuneService;
import com.practicespring.model.Coach;
import com.practicespring.model.MartialArtsCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.practicespring")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    public SeriousFortuneService seriousFortuneService(){
        return new SeriousFortuneService();
    }

    @Bean("myMartialArtsCoach")
    public Coach martialArtsCoach(){
        return new MartialArtsCoach(seriousFortuneService());
    }
}
