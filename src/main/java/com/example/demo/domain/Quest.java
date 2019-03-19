package com.example.demo.domain;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Quest {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String description;

    private int reward = 100;

    private int lenghtSec = 30;

    private boolean started = false;

    private boolean completed = false;

    private LocalDateTime localDateTime;

    public Quest(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Quest(String description) {
        this.description = description;
    }

    public Quest() {

    }

    public int getReward() {
        return reward;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLenght() {
        return lenghtSec;
    }

    public void setLenght(int lenght) {
        this.lenghtSec = lenght;
    }



    public void setStarted(boolean started) {
        this.started = started;
    }

    public int getLenghtSec() {
        return lenghtSec;
    }

    public void setLenghtSec(int lenghtSec) {
        this.lenghtSec = lenghtSec;
    }

    public boolean isStarted() {
        return started;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    @Override
    public String toString() {
        return " Ma za zadanie " + description;
    }
}
