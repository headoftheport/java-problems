import java.util.List;
import java.util.ArrayList;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
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
    
}
