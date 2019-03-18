package com.example.demo.controller;

import com.example.demo.domain.Knight;
import com.example.demo.domain.Quest;
import com.example.demo.repo.KnightRepository;
import com.example.demo.repo.QuestRepository;
import com.example.demo.service.KnightService;
import com.example.demo.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class QuestController {

    @Autowired
    QuestService questService;
    @Autowired
    QuestRepository questRepository;
    @Autowired
    KnightRepository knightRepository;
    @Autowired
    KnightService knightService;


    @GetMapping("/chooseTask")
    public String getAllQuest(@RequestParam("id") Integer id, Model model) {
        Knight knight = knightRepository.getOneKnight(id);
        List<Quest> questList = questService.getAllNoStarted();
        model.addAttribute("quests", questList);
        model.addAttribute("knight", knight);
        return "chooseTask";
    }

    @PostMapping(value = "/chooseTask")
    public String saveQuest(Knight knight) {
        knightService.updateKnight(knight);

        Quest quest = knight.getQuest();
        questService.updateQuest(quest);

        return "redirect:/knightList";
    }

}
