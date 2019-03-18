package com.example.demo.service;

import com.example.demo.domain.Knight;
import com.example.demo.repo.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

    public List<Knight> knightList() {
        List<Knight> getAllKnight = knightRepository.knightList();
        return getAllKnight;
    }

    public void save(Knight knight) {
        knightRepository.createKnight(knight);
    }

    public Knight getOneKnight(Integer id) {
       return knightRepository.getOneKnight(id);
    }

    public void delete(Integer id) {
        knightRepository.delete(id);
    }

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(),knight);
    }
}
