package priorityqueue;

import java.util.PriorityQueue;
import java.util.Comparator;

public class KthSmallestInSortedArray {
    
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[0]));
        for(int i = 0; i < Math.min(rows, k); i++){
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        int ans = -1;
        for(int i = 0; i < k; i++){
            int[] vals = pq.poll();
            int r = vals[1];
            int c = vals[2];
            ans = vals[0];
            if(c+1 < columns){
                pq.offer(new int[]{matrix[r][c+1], r, c+1});
            }
        }
        return ans;
    }
}
