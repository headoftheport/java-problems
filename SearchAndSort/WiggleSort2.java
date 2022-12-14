package SearchAndSort;

import java.util.Arrays;

public class WiggleSort2 {

    public void wiggleSort(int[] nums) {
        
        int n = nums.length, m = (n + 1) >> 1;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
    
        for (int i = m - 1, j = 0; i >= 0; i--, j += 2) nums[j] = copy[i];
        for (int i = n - 1, j = 1; i >= m; i--, j += 2) nums[j] = copy[i];
         
    }
    
}
