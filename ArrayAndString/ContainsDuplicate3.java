import java.util.TreeSet;

public class ContainsDuplicate3 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        /*
         * brute force sliding window
         * time: O(n*k)
         * space: O(1)
         */
        int low = 0;
        int high = 0;
        while(low < nums.length-1){
            high = Math.min(low + indexDiff, nums.length-1);
            while(low < high){
                if(Math.abs(nums[low] - nums[high]) <= valueDiff){
                    return true;
                }
                high--;
            }
            low++;
        }
        return false;   
        
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int indexDiff, int valueDiff) {
        /*
         * using binary search tree (TreeSet)
         * time O(n*logk)
         * space O(k)
         */
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            Integer floor = ts.floor(nums[i]);
            Integer ceil = ts.ceiling(nums[i]);
            if((floor != null && nums[i]-floor <= valueDiff) || ( ceil != null && ceil-nums[i] <= valueDiff)){
                return true;
            }
            ts.add(nums[i]);
            if( i >= indexDiff){
                ts.remove(nums[i-indexDiff]);
            }
            
        }
        return false;
        
    }
}
    
}
