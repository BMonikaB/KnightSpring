package com.example.demo.controller;

import com.example.demo.domain.Knight;
import com.example.demo.domain.PlayerInformation;
import com.example.demo.domain.TimeComponent;
import com.example.demo.repo.KnightRepository;
import com.example.demo.service.KnightService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class KnightsController {

    @Autowired
    KnightService knightService;
    @Autowired
    TimeComponent timeComponent;
    @Autowired
    PlayerInformation playerInformation;

    @GetMapping("/knightList")
    public String knightsList(Model model) {
        List<Knight> knights = knightService.knightList();
        model.addAttribute("knights", knights);
        model.addAttribute("time", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knightList";
    }

    @GetMapping("createKnight")
    public String addKnight(Model model) {
        model.addAttribute("knight", new Knight());
        model.addAttribute("playerinformation", playerInformation);
        model.addAttribute("time", timeComponent);
        return "createKnight";
    }

    @PostMapping(value = "/knightList")
    public String saveKnight(@Valid Knight knight, BindingResult result) {

        if(result.hasErrors()){
            System.out.println("Blad");
            result.getAllErrors().stream().map(c-> c.getObjectName() + c.getDefaultMessage()).forEach(System.out::println);
            return "createKnight";

        }
        else {
            knightService.save(knight);
            return "redirect:/knightList";
        }
    }


    @GetMapping(value = "/knightList/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        knightService.delete(id);
        return "redirect:/knightList";
    }


    @GetMapping(value = "/showMore/show/{id}")
    public String getOne(@PathVariable("id") Integer id, Model model) {
        Knight knight = knightService.getOneKnight(id);
        model.addAttribute("time", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        model.addAttribute("knight", knight);
        return "showMore";
    }


}
