package linearscanning;

public class MaximumProductSubarray {
    
    public int maxProduct(int[] nums) {
        /* 
         * single pass
         * time complexity : O(n)
         * space complexity: O(1);
         */
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if( max > result){
                result = max;
            }
        }
        
        return result;
        
    }

    public int maxProduct2(int[] nums) {
        
         /*  
         * two pass
         * time complexity : O(n)
         * space complexity: O(1);
         */
        int result = Integer.MIN_VALUE;
        int prod = 1;
        
        for(int i = 0; i < nums.length; i++){
            prod = prod * nums[i];
            result = Math.max(prod, result);
            if(prod == 0){
                prod = 1;
            }
        }
        
        prod = 1;
        
        for (int i = nums.length-1; i >= 0; i--){
            prod = prod * nums[i];
            result = Math.max(prod, result);
            if(prod == 0){
                prod = 1;
            }
        }
        
        return result;
        
    }
}
