import java.util.Random;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0; i < nums.length; i++){
            queue.offer(nums[i]);
            while(queue.size() > k){
                queue.poll();
            }
        }
    
        return queue.peek();
        
    }

    public int findKthLargest2(int[] nums, int k){
        return quickSelect(nums, 0, nums.length-1, k);

    }

    public int quickSelect2(int[] nums, int start, int end, int k){

        int randIndex = (int)(Math.random()*(end-start+1)+start);
        swap(nums, randIndex, end);
        int pivot = end, p1 = start;
        for(int i = start; i < end; i++){
            if(nums[i] < nums[pivot]){
                swap(nums, p1++, i);
            }
        }
        swap(nums, p1, end);

        int count = end - p1 + 1;
        if(count == k){
            return nums[p1];
        }

        if(count > k){
            return quickSelect(nums, p1+1, end, k);
        }
        return quickSelect(nums, start, p1-1, k-count);

    
    }

    public void swap(int[] nums, int s, int d){
        int temp = nums[s];
        nums[s] = nums[d];
        nums[d] = temp;
    }


    public int findKthLargest2(int[] nums, int k){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int bucketSize = max - min;
        // System.out.println(bucketSize);
        int[] bucket = new int[bucketSize+1];
        for(int num: nums){
            bucket[num-min]++;
        }
        int count = 0;
        for(int i = bucketSize; i >= 0; i--){
                count += bucket[i];
                if(count >= k){
                    return i+min;
                }
        }
        return -1;



    }

    
}
