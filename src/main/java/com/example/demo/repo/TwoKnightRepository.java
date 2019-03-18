package com.example.demo.repo;

import com.example.demo.domain.Knight;
import org.springframework.stereotype.Repository;

import java.util.List;

public class TwoKnightRepository implements KnightRepository{


    @Override
    public void createKnight(int id, String name, int age) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Knight> knightList() {
        return null;
    }

    @Override
    public Knight getOneKnight(int id) {
        return null;
    }

    @Override
    public void create() {

    }

    @Override
    public void createKnight(Knight knight) {

    }

    @Override
    public void updateKnight(int id, Knight knight) {

    }
}
