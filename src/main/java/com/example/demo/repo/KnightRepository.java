package com.example.demo.repo;

import com.example.demo.domain.Knight;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

public interface KnightRepository {
    void createKnight(String name, int age);

    void delete(int id);

    List<Knight> knightList();

    Knight getOneKnight(int id);

    @PostConstruct
    void create();

    void createKnight(Knight knight);

    void updateKnight(int id, Knight knight);


    public Optional<Knight> getOneKnightName(String name);
}
