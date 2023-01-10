package math;

import java.util.Map;
import java.util.HashMap;

public class MaxPointOnLine {
    
    public int maxPoints(int[][] points) {
        /*
         * tc: O(n^2)
         * sc: O(n)
         */
        if(points.length == 1){
            return 1;
        }
        
        int maxLen = 0;
        
        for( int i = 0; i < points.length; i++ ){
            Map<Double, Integer> temp = new HashMap<Double, Integer>();
            for( int j = i+1; j < points.length; j++){
                
                double slope = findSlope(points[i], points[j]);
                temp.put(slope, temp.getOrDefault(slope, 0) + 1);
                maxLen = Math.max(maxLen, temp.get(slope));
            }
            
        }
        
        return maxLen + 1;
    }
    
    public Double findSlope(int[] pointA, int[] pointB){
        
        int x = pointA[0];
        int y = pointA[1];
        
        int x1 = pointB[0];
        int y1 = pointB[1];
        
        if(x == x1){
            return (double)0;
        }
        
        if(y == y1){
            return (double)Integer.MAX_VALUE;
        }
        
        return (double)(x - x1)/(y-y1);
    }

    public int maxPoints2(int[][] points) {
        /*
         * with out using the double key and using gcd technique
         */
        if(points.length <= 2){
            return points.length;
        }
        
        int maxLen = 0;
        for( int i = 0; i < points.length; i++ ){
            Map<String, Integer> temp = new HashMap<String, Integer>();
            int duplicate = 0;
            int max = 0;
            for( int j = i+1; j < points.length; j++){
                
               int dx = points[i][0] - points[j][0];
               int dy = points[i][1] - points[j][1];
                
                if ( dx == 0 && dy == 0){
                    duplicate++;
                    continue;
                }
                
                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;
                
                temp.put(dx + "," + dy, temp.getOrDefault(dx + "," + dy, 0)+1);
                max = Math.max(max, temp.get(dx + "," + dy));
            }
            
            maxLen = Math.max(maxLen, max+duplicate+1);
        }
        
        return maxLen;
    }
    
    public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }

}
