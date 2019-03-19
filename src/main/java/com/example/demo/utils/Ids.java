package com.example.demo.utils;

import java.util.Comparator;
import java.util.Set;

public class Ids {



    public static int getNewId(Set<Integer> integerSet){

        if(integerSet.isEmpty()){
            return 0;
        }
        else{
            Integer integer = integerSet.stream().max((o1, o2) -> o1.compareTo(o2)).get();
            return integer+1;
        }
}

}
