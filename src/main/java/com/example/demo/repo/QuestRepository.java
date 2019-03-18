package com.example.demo.repo;

import com.example.demo.domain.Knight;
import com.example.demo.domain.Quest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class QuestRepository {

    Map<Integer, Quest> questList = new HashMap<>();

    private Random random = new Random();


    public void createQuest(Quest quest) {
        questList.put(quest.getId(),new Quest(quest.getId(),quest.getDescription()));
    }


    public void deleteQuest(Quest quest) {
        System.out.println(questList.remove(quest));
    }

    public List<Quest> getQuestList() {
        return new ArrayList<>(questList.values());
    }

    @PostConstruct
    public void addQuest() {
     /*   createQuest(1,"Uratuj ksiezniczke");
        createQuest(2,"Zabij smoka");
        createQuest(3,"Nic nie rób");
        createQuest(4,"Pójdz na turniej");
     */
    }


    public void createRandomQuest() {
        List<String> description = new ArrayList<>();

        description.add("Zabij smoka");
        description.add("Uratuj ksiezniczke");
        description.add("Zabij bande goblinow");
        description.add("Wez udział w turnieju");

        String desc = description.get(random.nextInt(description.size()));
        createQuest(new Quest(desc));
    }

    public void delete(Quest quest) {
        System.out.println(questList.remove(quest));
    }

    @Override
    public String toString() {
        return "QuestRepository{" + "questList=" + questList + '}';
    }

    public void updateQuest(Quest quest) {
        questList.put(quest.getId(),quest);
    }

    public Quest getQuestId(Integer id) {
        return questList.get(id);
    }
}
