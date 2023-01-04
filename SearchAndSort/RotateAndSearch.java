public class RotateAndSearch {
    
    public int search(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            /*
             * binary search
             * time longn
             */
            int mid = (start + end) / 2;
            // System.out.println(mid + " " + nums[mid]);
            if(nums[mid] == target){
                return mid;
            }
            
            if(nums[start] <= nums[mid]){
                if( target >= nums[start] && target < nums[mid] ){
                    end = end - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(target > nums[mid] && target <= nums[end] ){
                    start = mid + 1 ;
                }
                else{
                    end = end - 1;
                }
            }
        }
        
        return -1;
        
    }
}
