package com.example.demo.domain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class KnightTest {


    @Test
    public void knightStart(){
        Knight knight = new Knight("Anna",25);
        Quest quest = new Quest("Uratuj ksiezniczke");
        knight.setQuest(quest);


        boolean flaga = quest.isStarted();
        assertTrue(knight.getQuest().isStarted());
    }

}
