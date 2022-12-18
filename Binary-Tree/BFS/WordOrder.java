package BFS;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class WordOrder {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
        space complexity: O( m^2 * n)
        time complexity: O(m^2 * n ) 
         */
        int L = beginWord.length();
        
        Map<String, List<String>> alComb = new HashMap<>();
        
        wordList.forEach( word -> {
            for(int i = 0; i < L; i++){
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, L);
                List<String> trans = alComb.getOrDefault(newWord, new ArrayList<>());
                trans.add(word);
                alComb.put(newWord, trans);
            }
        });
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                String curr = queue.poll();
                for(int j = 0; j < L; j++){
                    String newWord = curr.substring(0, j) + '*' + curr.substring(j+1, L);
                    List<String> temp = alComb.getOrDefault(newWord, new ArrayList<>());
                    for(String word: temp){
                        if(word.equals(endWord)){
                            return step + 1;
                        }
                        
                        if(!visited.containsKey(word)){
                            visited.put(word, true);
                            queue.offer(word);
                        }
                    }
                }
            }
            step = step + 1;
        }
         return 0;
    }
}
