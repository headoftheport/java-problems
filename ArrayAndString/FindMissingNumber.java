class Solution {
    public int firstMissingPositive(int[] nums) {
        
        /*
         * cyclic sort
         * tc: o(n)
         * sc: o(1)
         */
        int start = 0;
        
        while(start < nums.length){
            if( nums[start] > 0 && nums[start] <= nums.length && nums[start] != nums[nums[start]-1]){
                swap(nums, start, nums[start]-1);
            }
            else{
                start++;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        
        return nums.length+1;
        
    }
    
    private void swap(int[] nums, int i, int j){
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
}
