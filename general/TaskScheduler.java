import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        /*
         * using priority queue
         * time complexity: O(time to count + time to construct queue + time to schedule ) = O(3n)
         * space complexity: O(n)
         */
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: tasks){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        
        queue.addAll(map.entrySet());
        
        int time = 0;
        
        while(!queue.isEmpty()){
            int interval = n+1;
            List<Map.Entry<Character,Integer>> list = new ArrayList<>();
            while(interval > 0 && !queue.isEmpty()){
                Map.Entry<Character,Integer> item = queue.poll();
                item.setValue(item.getValue()-1);
                list.add(item);
                interval--;
                time++;
                    
            }
            
            for(Map.Entry<Character,Integer> item: list){
                if(item.getValue() > 0){
                    queue.offer(item);
                }
            }
            
            if(queue.isEmpty()){
                break;
            }
                
            time = time + interval;
        }
        
        return time;
    }

    public int leastInterval2(char[] tasks, int n) {
        /*
         * mathematical computations
         * time complexity: O(n)
         * space complexity: O(1)
         */
        int[] store = new int[26];
        int max = 0;
        int maxJobs = 0;
        for(char c:tasks){
            store[c-'A']++;
            if(max==store[c-'A']){
                maxJobs++;
            }
            else if(max < store[c-'A']){
                max = store[c-'A'];
                maxJobs = 1;       
            }
        }
        // System.out.println(max);
        return Math.max(tasks.length, (max-1) * (n+1) + maxJobs );
        
        
    }
}