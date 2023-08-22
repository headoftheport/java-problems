public class DuplicateNumber {
    
    public int findDuplicate(int[] nums) {
        
        int ans = -1;
        for(int i = 0; i < nums.length; i++){
            int curr = Math.abs(nums[i]);
            if(nums[curr]< 0 ){
                ans = curr;
                break;
            }

            nums[curr] = -nums[curr];
        }

        return ans;
    }


    public int findDuplicate2(int[] nums) {
        
        while(nums[0] != nums[nums[0]] ){
            
            int temp = nums[0];
            nums[0] = nums[temp];
            nums[temp] = temp;
        }
        
        return nums[0];
    }
    
}
