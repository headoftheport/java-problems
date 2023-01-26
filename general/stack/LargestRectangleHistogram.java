package stack;

public class LargestRectangleHistogram {
    
    public int largestRectangleArea(int[] heights) {
        
        /*
         * tc: O(n)
         * sc: O(n)
         */
        int length = heights.length;
        int [] stack = new int[length + 1];
        int iter = -1;
        int maxArea = 0;
        for(int i = 0; i <= length; i++){
            int height = (i == length) ? 0: heights[i];
            while(iter != -1 && heights[stack[iter]] > height){
                int temp = heights[stack[iter--]];
                int width = (iter == -1) ? i : i - 1 - stack[iter];
                maxArea = Math.max(maxArea, temp * width);
            }
            
            stack[++iter] = i;
            // System.out.println(Arrays.toString(stack));
            // System.out.println(maxArea);
        }
        // System.out.println(count);
        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        
        /*
         * tc: O(n)
         * sc: O(n)
         */
        int lessFromLeft[] = new int[heights.length];
        int lessFromRight[] = new int[heights.length];
        lessFromRight[heights.length-1] = heights.length;
        lessFromLeft[0] = -1;
        
        for(int i=1; i < heights.length; i++ ){
            int p = i-1;
            while(p >= 0 && heights[p] >= heights[i]){
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        
        for(int i=heights.length-2; i >= 0; i-- ){
            int p = i+1;
            while(p < heights.length && heights[p] >= heights[i]){
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        
        
        int maxArea = 0;
        for(int i=0; i < heights.length; i++ ){
            maxArea = Math.max(maxArea, heights[i] * ( lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return maxArea;
    }
}
