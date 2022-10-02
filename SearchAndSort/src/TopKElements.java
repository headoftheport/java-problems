import java.util.PriorityQueue;
import java.util.HashMap;

public class TopKElements {

    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> occCount = new HashMap<Integer, Integer>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(( a,  b) -> (b.getValue()-a.getValue()));
        
        int[] returnList = new int[k];
        for(int i: nums){
           if(!occCount.containsKey(i)){
               occCount.put(i, 0);
           }
            occCount.put(i, occCount.get(i)+1);
             
        }
        pq.addAll(occCount.entrySet());
        for(int i = 0; i < k; i++){
           returnList[i] = pq.poll().getKey();
        }
        
        return returnList;  
        
    }
    
}
