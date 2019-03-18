package com.example.demo.config;

import com.example.demo.repo.KnightRepository;
import com.example.demo.repo.OneKnightRepository;
import com.example.demo.repo.TwoKnightRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MainConfiguration {


    @Bean
    @Profile("one")
    public KnightRepository oneKnight(){
        KnightRepository knightRepository = new OneKnightRepository();
        return knightRepository;
    }

    @Bean
    @Profile("two")
    public KnightRepository twoKnight(){
        KnightRepository knightRepository = new TwoKnightRepository();
        return knightRepository;
    }

}
