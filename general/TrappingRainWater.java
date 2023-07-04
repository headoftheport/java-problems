public class TrappingRainWater {
    
    public int trap(int[] height) {
        
        /*
         * tc: n
         * sc: 1
         */

        int left = 0;
        int right = height.length - 1;

        int ans = 0;
        int left_max = 0;
        int right_max = 0;

        while(left < right){

            if(height[left] <  height[right]){

                if(height[left] < left_max){
                    ans += (left_max - height[left]);
                }
                else{
                    left_max = height[left];
                } 
                left++;
            }
            else{
                
                if(height[right] < right_max) {
                    ans += ( right_max - height[right]);
                }
                else{
                    right_max = height[right];
                }
                right--;
            }
        }

        return ans;

    }

    public int trap2(int[] height) {
        
        /*
         * tc: n
         * sc: n
         */
        int size = height.length;
        int[] maxFromLeft =  new int[size];
        int[] maxFromRight = new int[size];
        maxFromLeft[0] = height[0];
        maxFromRight[size-1] = height[size-1];
        for(int i = 1; i < size; i++ ){
            maxFromLeft[i] = Math.max(height[i], maxFromLeft[i-1]);
        }
        
        for(int i = size-2; i >= 0; i-- ){
            maxFromRight[i] = Math.max(height[i], maxFromRight[i+1]);
        }
        
        int ans = 0;
        for(int i = 0; i < size; i++){
            ans += Math.min(maxFromLeft[i], maxFromRight[i]) - height[i];
        }
        
        return ans;
    }
}
