package com.example.demo.repo;

import com.example.demo.domain.Knight;
import com.example.demo.utils.Ids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class OneKnightRepository implements KnightRepository {


    private Map<Integer,Knight> knights = new HashMap<>();

    @Override
    public void createKnight(String name, int age){
       Knight knight = new Knight(name, age);
        knight.setId(Ids.getNewId(knights.keySet()));
        knights.put(knight.getId(),new Knight(name,age));

    }

    @Override
    public void delete(int id){
        knights.remove(id);
    }

    @Override
    public List<Knight> knightList(){
        List<Knight> knightList = knights.values().stream().collect(Collectors.toList());
        return knightList;

    }

    public Map<Integer, Knight> getKnights() {
        return knights;
    }

    @Override
    public Knight getOneKnight(int id){
      Knight knight  = knights.get(id);
      return knight;
    }

    public Optional<Knight> getOneKnightName(String name){

        Optional<Knight> knightByName = knights.values().stream().filter(knight -> knight.getName().equals(name)).findAny();
        return knightByName;
    }


    @Override
    @PostConstruct
    public void create() {

        Knight lancelot = new Knight("Lancelot", 20);
        Knight percival = new Knight("Percival",30);



        createKnight(lancelot);
        createKnight(percival);
        }

    @Override
    public void createKnight(Knight knight) {
        knight.setId(Ids.getNewId(knights.keySet()));
        knights.put(knight.getId(),knight);
    }

    @Override
    public void updateKnight(int id, Knight knight) {
        knights.put(id,knight);
    }

    @Override
    public String toString() {
        return "OneKnightRepository{" + "knights=" + knights + '}';
    }
}
