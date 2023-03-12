package binarysearch;

public class KthSmallestInSortedArray {
    
    public int kthSmallest(int[][] matrix, int k) {
        
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix[0].length-1] + 1;
        
        while( low < high ){
            int mid = low + (high - low ) / 2;
            int count = 0;
            for(int i = 0; i < matrix.length; i++){
                int j = matrix[i].length-1;
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                count += (j+1);
            }
            
            if (count < k ){
                low =  mid + 1;
            }
            else{
                high = mid;
            }
        }
        
        return low;
        
    }
}
