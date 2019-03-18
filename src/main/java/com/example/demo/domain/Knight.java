package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Knight {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    @NotNull
    @Min(18)
    @Max(100)
    private int age;
    private int level;
    private Quest quest;

    public Knight() {

    }

    public Knight(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.level = 1;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Quest getQuest() {
        return quest;
    }


    public int getLevel() {
        return level;
    }

    public Knight(Quest quest) {
        this.quest = quest;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
        quest.setStarted(true);
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu : " + name + "(" + age + ")" + quest;
    }
}
