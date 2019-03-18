package com.example.demo.service;

import com.example.demo.domain.Knight;
import com.example.demo.domain.Quest;
import com.example.demo.repo.KnightRepository;
import com.example.demo.repo.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@Service
public class QuestService {

    @Autowired
    KnightRepository knightRepository;
    @Autowired
    QuestRepository questRepository;

    private Random random = new Random();

    public void assignAtask(int id) {
        List<Quest> allKnight = questRepository.getQuestList();
        Quest quest = allKnight.get(random.nextInt(allKnight.size()));
        knightRepository.getOneKnight(id).setQuest(quest);
        questRepository.deleteQuest(quest);


    }

    public List<Quest> getAllNoStarted() {
        List<Quest> questList = questRepository.getQuestList().stream().filter(s -> !s.isStarted()).collect(Collectors.toList());
        return questList;
    }

    public void updateQuest(Quest quest) {
        questRepository.updateQuest(quest);
    }
}
