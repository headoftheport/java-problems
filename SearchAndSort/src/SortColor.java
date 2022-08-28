public class SortColor {
    
    public void sortColors(int[] nums) {
        /*
         * two pass counting sort with constant space
         */
        int[] count = new int[3];
        
        for(int i: nums){
            count[i] ++;
        }
        int run = 0;
        for(int i = 0; i <= 2; i++){
            while(count[i] > 0){
                nums[run++] = i;
                count[i]--;
            }
        }
          
        return;
        
    }

    public void sortColors2(int[] nums) {
        /*
         * single pass swapping
         */
        int left = 0;
        int right = nums.length - 1;
        int ptr = 0;
        while(ptr <= right){
            
            if(nums[ptr] == 0){
                swap(nums, ptr, left);
                left++;
                ptr++;
            }
            else if(nums[ptr] == 2){
                swap(nums, ptr, right);
                right--;
            }
            else{
                ptr++;
            }
        }
        
    }
    
    public void swap(int[] nums, int from, int to){
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    public void sortColors3(int[] nums){

        int n0 = -1, n1 = -1, n2 = -1;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == 0){
                nums[++n2] = 2; nums[++n1] = 1; nums[++n0] = 0;
            }
            else if(nums[i] == 1){
                nums[++n2] = 2; nums[++n1] = 1;
            }
            else if(nums[i] == 2){
                nums[++n2] = 2;
            }
        }
    }

    public void sortColors4(int[] nums){

        int left = 0, right = nums.length-1;

        for(int i = 0; i <= right; i++){
            if(nums[i] == 0){
                swap(nums, left, i);
                left++;
            }
            if(nums[i] == 2){
                swap(nums, right, i);
                    right--;
                    i--;
            }
        }
    }
}
