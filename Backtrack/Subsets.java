import java.util.List;
import java.util.ArrayList;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        /*
         * backtrack
         * time: O(n*2^n)
         * space: O(n)
         */
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans, new ArrayList<>());
        return ans;
     }
     
     public void helper(int[] nums, int start, List<List<Integer>> ans, List<Integer> temp){
        ans.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            helper(nums, i + 1, ans, temp);
            temp.remove(temp.size()-1);
        }
         
         
     }

     public List<List<Integer>> subsets2(int[] nums) {
        /*
         * bitmask
         * time: O(n*2^n)
         * space: O(n) 
         */
        List<List<Integer>> ans = new ArrayList<>();
        int output  = 1 << nums.length;
        for(int i = 0; i < output; i++){
            ans.add(new ArrayList<>());
        }
        for(int i = 0; i < output; i++){
            for(int j = 0; j < nums.length; j++){
                if( i >> j & 1){
                    ans[i].add(nums[j]);
                }
            }
        }
     }

     public List<List<Integer>> subsets3(int[] nums) {

        /*
         * array expansion
         * time: O(n*2^n)
         * space: O(n*2^n)
         */
        
        List<List<Integer>> ans = new ArrayList();
        ans.add(new ArrayList());
        for(int i = 0; i < nums.length; i++){
            List<List<Integer>> temp = new ArrayList();
            for(List<Integer> item: ans){
                List<Integer> k = new ArrayList<>(item);
                k.add(nums[i]);
                temp.add(k);
            }
            
            ans.addAll(temp);
        }
        
        return ans;
        
    }
    
}
