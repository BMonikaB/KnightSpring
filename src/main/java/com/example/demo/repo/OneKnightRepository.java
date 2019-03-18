package com.example.demo.repo;

import com.example.demo.domain.Knight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;


public class OneKnightRepository implements KnightRepository {




    private Map<Integer,Knight> knights = new HashMap<>();

    @Override
    public void createKnight(int id,String name, int age){
        knights.put(id,new Knight(id,name,age));
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





    @Override
    @PostConstruct
    public void create() {

        Knight lancelot = new Knight(1,"Lancelot", 20);
        Knight percival = new Knight(2,"Percival",30);



        createKnight(lancelot);
        createKnight(percival);
        }

    @Override
    public void createKnight(Knight knight) {
        knights.put(knight.getId(),new Knight(knight.getId(),knight.getName(),knight.getAge()));
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
