package com.example.demo;


import com.example.demo.domain.TimeComponent;
import com.example.demo.repo.KnightRepository;
import com.example.demo.repo.QuestRepository;
import com.example.demo.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class Starter implements CommandLineRunner {


    @Autowired
    KnightRepository knightRepository;
    @Autowired
    QuestRepository questRepository;
    @Autowired
    QuestService questService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        knightRepository.createKnight("Percival",32);

        questService.assignAtask("Percival");


    }


}
