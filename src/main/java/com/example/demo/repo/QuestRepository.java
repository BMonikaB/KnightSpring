package com.example.demo.repo;

import com.example.demo.domain.Quest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Repository
public class QuestRepository {


    @PersistenceContext
    private EntityManager entityManager;

    //Map<Integer, Quest> questList = new HashMap<>();

    private Random random = new Random();


    @Transactional
    public void createQuest(String description) {
        Quest quest = new Quest(description);
        entityManager.persist(quest);
        System.out.println(quest);
    }


    public void deleteQuest(Quest quest) {
        entityManager.remove(quest);
    }

    public List<Quest> getQuestList() {

        return entityManager.createQuery("SELECT q from Quest q", Quest.class).getResultList();
    }

    @PostConstruct
    public void addQuest() {
     /*   createQuest(1,"Uratuj ksiezniczke");
        createQuest(2,"Zabij smoka");
        createQuest(3,"Nic nie rób");
        createQuest(4,"Pójdz na turniej");
     */
    }


    @Transactional
    public void createRandomQuest() {
        List<String> description = new ArrayList<>();

        description.add("Zabij smoka");
        description.add("Uratuj ksiezniczke");
        description.add("Zabij bande goblinow");
        description.add("Wez udział w turnieju");

        String desc = description.get(random.nextInt(description.size()));
        createQuest(desc);
    }

    public void delete(Quest quest) {
      //  System.out.println(questList.remove(quest));
        entityManager.remove(quest);
    }


    @Transactional
    public void updateQuest(Quest quest) {
        entityManager.merge(quest);
    }

    @Transactional
    public Quest getQuestId(Integer id) {
        return entityManager.find(Quest.class, id);

    }

    @Override
    public String toString() {
        return "QuestRepository{" + "entityManager=" + entityManager + ", random=" + random + '}';
    }
}
