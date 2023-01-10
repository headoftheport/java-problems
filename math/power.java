public class power {
    
    public int mySqrt(int x) {
        /*
         * newton method, 
         * time ; O(logn)
         */
        long r = x;
        while(r*r > x){
            r = (r + x/r) / 2;
        }
        
        return (int)r;
    }

    public int mySqrt2(int x) {
        /*
         * binary search
         * time: logn
         */
        long start = 0;
        long end = (long)x;
        long mid = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(mid * mid == x){
                return (int)mid;
            }
            
            if(mid*mid > x){
                end = mid - 1;
            }
            else{
                if((mid+1)*(mid+1) > x){
                    return (int)mid;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        
        return (int)mid;
    }
}
