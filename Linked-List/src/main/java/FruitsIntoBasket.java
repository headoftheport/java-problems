package main.java;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    
    public int totalFruits(int[] fruits){

        Map<Integer, Integer> store = new HashMap<>();
        int start = 0;
        int res = 0;
        for(int i = 0; i < fruits.length; i++){
            store.put(fruits[i], store.getOrDefault(fruits[i], 0) + 1);
            while(store.size() > 2){
                store.put(fruits[start], store.get(fruits[start])-1);
                store.remove(fruits[start], 0);
                start++;
            }
            res = Math.max(res, i - start + 1);
        }

        return res;
    }
}
