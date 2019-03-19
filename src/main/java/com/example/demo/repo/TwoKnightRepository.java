package com.example.demo.repo;

import com.example.demo.domain.Knight;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class TwoKnightRepository implements KnightRepository {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void createKnight(String name, int age) {
        Knight knight = new Knight(name, age);
        entityManager.persist(knight);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(id);
    }

    @Override
    public List<Knight> knightList() {
        return entityManager.createQuery("SELECT s FROM Knight s", Knight.class).getResultList();
    }

    @Override
    public Knight getOneKnight(int id) {
        return entityManager.find(Knight.class, id);
    }

    @Override
    public void create() {

    }


    @Override
    @Transactional
    public void createKnight(Knight knight) {
        entityManager.persist(knight);
    }

    @Override
    @Transactional
    public void updateKnight(int id, Knight knight) {

        entityManager.merge(knight);
    }

    @Override
    public Optional<Knight> getOneKnightName(String name) {
        Knight knight = entityManager.createQuery("SELECT s FROM Knight s WHERE s.name=:name", Knight.class).setParameter("name",name).getSingleResult();

        return Optional.ofNullable(knight);
    }
}
