import java.util.HashMap;

public class MajorityElement {
    
    public int majorityElement(int[] nums) {
        /*
         * using hash map
         */
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = nums.length;
        int count = 0;
        int number = Integer.MAX_VALUE;
        for(int i: nums){
            if(!hm.containsKey(i)){
                hm.put(i,0);
            }
            int curr = hm.get(i);
            curr = curr + 1;
            if(curr > max/2){
                return i;
            }
            if(curr > count){
                number = i;
            }
            hm.put(i, curr);
        }
        
        return number;
        
    }


    public int majorityElement2(int[] nums){
        /*
         * using the constant space, Boyer-Moore Voting Algorithm
         * 
         */
        int can = -1;
        int count = 0;
        for(int i: nums){
            if(count == 0){
                can = i;
                count++;
            }
            else if(can != i){
                count--;
            }
            else{
                count++;
            }
        }
        
        return can;

    }

    public int majorityElement3(int[] nums){
        /*
         * divide and conquer method
         * time complexity: o(nlogn)
         * space complexity: o(logn)
         */
        return majorityElementRec(nums, 0, nums.length-1);
    }

    public int majorityElementRec(int[] nums, int start, int end){

        if(start == end){
            return nums[start];
        }

        int mid = (start + end) / 2;
        int left = majorityElementRec(nums, start, mid);
        int right = majorityElementRec(nums,mid+1, end);

        if(left == right){
            return left;
        }

        int leftCount = count(nums, left, start, end);
        int rightCount = count(nums, right, start, end);

        return leftCount > rightCount ? left : right;
    }

    public int count(int[] nums, int val, int left, int right){
        int count = 0;
        for(int i = left; i <= right; i++){
            if(nums[i] == val){
                count++;
            }
        }
        return count;
    }
}
