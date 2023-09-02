import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] res = new int[nums.length-k+1];
        int index = 0;
        
        for(int i = 0; i < nums.length ; i++){
            
            if(deque.size() > 0 && deque.peekFirst() == i-k){
                deque.pollFirst();
            }
            
            while(deque.size() > 0 && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            if( i >= k-1 ){
                res[index++] = nums[deque.peekFirst()];
            }
        }
        
        return res;
    }
}
