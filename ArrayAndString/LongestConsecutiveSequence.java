import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        /* 
         * tc: nlogn
         * sc: 1
         */
        if( nums.length == 0){
            return 0;
        }
        // List<Integer> array = new ArrayList<Integer>(nums);
        
        Arrays.sort(nums);
        
        int ret = 1;
        int count = 1;
        
        for(int i = 1; i < nums.length; i++){
            
            if( nums[i] - nums[i-1] == 1){
                count++;
            }
            else if( nums[i] - nums[i-1] == 0){
                continue;
            }
            else{
                count = 1;
            }
            
            ret = Math.max(ret, count);
        }
        
        return ret;

        
    }

    public int longestConsecutive2(int[] nums) {

        /* 
         * tc: n
         * sc: n
         */
        Set<Integer> store = new HashSet<Integer>();
        
        for(int i: nums){
            store.add(i);
        }
        int max = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            if(!store.contains(nums[i]-1)){
                int y = nums[i] + 1;
                while(store.contains(y)){
                    y++;
                }
                max = Math.max(max, y-nums[i]);
            }
        }
        
        return max;
    }

    public int longestConsecutive3(int[] nums) {
        
        /* 
         * tc: n
         * sc: n
         */
        
        Map<Integer, Integer> store = new HashMap<Integer, Integer>();
        int max = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            if(!store.containsKey(nums[i])){
                
                int left = store.getOrDefault(nums[i]-1, 0);
                int right = store.getOrDefault(nums[i]+1, 0);
                
                int dist = left + right + 1;
                
                max = Math.max(max, dist);
                
                store.put(nums[i], dist);
                store.put(nums[i] - left, dist);
                store.put(nums[i] + right, dist);
                
            }
        }
        
        return max;
    }
}
