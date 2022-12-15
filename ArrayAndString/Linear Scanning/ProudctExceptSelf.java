class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
        int mul = 1;
        int zeroCount = 0;
        for(int i:nums){
            if(i == 0){
                zeroCount++;
            }
            else{
                mul = mul * i;
            }
        }
        
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0 && zeroCount > 1){
                ans[i]=0;
            }
            else if(nums[i] == 0){
                ans[i] = mul;
            }
            else if(nums[i] != 0 && zeroCount > 0){
                ans[i] =0;
            }
            else{
                ans[i] = mul / nums[i];
            }
        }
        
        return ans;
        
        
    }

    public int[] productExceptSelf2(int[] nums) {
        
        int[] ans = new int[nums.length];
        int product = 1;
        for(int i = 0; i < nums.length; i++){
            product*=nums[i];
            ans[i]=product;
        }
        product = 1;
        for(int i = nums.length-1; i > 0; i--){
            ans[i] = ans[i-1]*product;
            product = product * nums[i];
        }
        ans[0]=product;
        return ans;
    }
}