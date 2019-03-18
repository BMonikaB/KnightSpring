package com.example.demo.service;

import com.example.demo.domain.Quest;
import com.example.demo.repo.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
public class QuestFormatter implements Formatter<Quest> {

    @Autowired
    QuestRepository questRepository;

    @Override
    public Quest parse(String idd, Locale locale) throws ParseException {
       Integer id = Integer.parseInt(idd);
       return questRepository.getQuestId(id);

    }

    @Override
    public String print(Quest quest, Locale locale) {
        return quest.toString();
    }
}
