import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        /* 
         * tc : O(m*n)
         * sc: O(m*n)
         */
        List<Integer> res = new ArrayList<Integer>();
        int row = matrix.length;
        if(row == 0) return res;
        int col = matrix[0].length;
        if(col == 0) return res;
        
        int[][] dir = {{0, 1}, {1 , 0}, {0, -1}, {-1, 0}};
        int[] count = {col, row-1};
        
        int r = 0;
        int c = -1;
        
        int direction = 0;
        
        while(count[direction%2] != 0)
        {
            for(int i = 0; i < count[direction%2]; i++){
                r += dir[direction][0];
                c += dir[direction][1];
                res.add(matrix[r][c]);
                    
            }
            count[direction%2]--;
            direction = (direction + 1) % 4;
        } 
        
        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        /* 
         * tc : O(m*n)
         * sc: O(m*n)
         */
        int start = 0;
        int width = matrix.length;
        int length  = matrix[0].length;
        List<Integer> ans = new ArrayList<Integer>();
        while(length > 0 && width > 0){
            ans.addAll(printRing(start, length, width, matrix));
            start++;
            length = length - 2;
            width = width - 2;
        }
        
        return ans;
        
    }
    
    
    public List<Integer> printRing(int start, int length, int width, int[][] matrix){
        List<Integer> ans = new ArrayList<Integer>();
        // System.out.println(start);
        // System.out.println(length);
        // System.out.println(width);
        for(int i = start; i < start + length; i++){
            ans.add(matrix[start][i]);
        }
        // System.out.println(ans);
        for(int i = start+1 ; i < start+width; i++){
            ans.add(matrix[i][start+length-1]);
        }
        if ( length == 1 || width == 1){
            return ans;
        }
        for(int i = start+length-2; i > start; i--){
            ans.add(matrix[start+width - 1][i]);
        }
        // System.out.println(ans);
        for(int i = start+width-1; i > start ; i--){
            ans.add(matrix[i][start]);
        }
        // System.out.println(ans);
        return ans;
    }
}
