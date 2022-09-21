import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Permutation {
    
    public List<List<Integer>> permute(int[] nums) {
       /*
        * back track 
        * time: O(n*n!)
        * space: O(n!)
        */
        List<List<Integer>> ret = new ArrayList<>();
        generate(nums, 0, new ArrayList<Integer>(), ret);
        return ret;
    
    }
    
    public void generate(int[] nums, int start, List<Integer> store, List<List<Integer>> ans){
        
        if(start ==nums.length){
            ans.add(new ArrayList<>(store));
            return;
        }
        
        for(int i = start; i < nums.length ; i++){
            store.add(nums[i]);
            swap(nums, start, i);
            generate(nums,start+1, store, ans);
            store.remove(store.size()-1);
            swap(nums, start, i);
        }
    }
    
    public void swap(int[] arr, int from, int to){
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }


    public List<List<Integer>> permute2(int[] nums) {
        /*
        * back track 
        * time: O(n*n!)
        * space: O(n!)
        */
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0){
            return ans;
        }
        
        ans.add(new ArrayList<Integer>(Arrays.asList(nums[0])));
        for(int i = 1; i < nums.length; i++){
             List<List<Integer>> temp = new ArrayList<>();
            for(int j = 0; j<= i; j++){
                for(List<Integer> l: ans){
                    List<Integer> new_l = new ArrayList<Integer>(l);
                    new_l.add(j,nums[i]);
                    temp.add(new_l);
                }
            }
            ans = temp;
        }
        
        return ans;
    }
}
