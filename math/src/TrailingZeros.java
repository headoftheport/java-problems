public class TrailingZeros {
    
    public int trailingZeroes(int n) {
        
        int zerocount = 0;
        while(n != 0){
            int temp = n / 5;
            zerocount += temp;
            n = temp;
        }
        
        return zerocount;
    }

    public int trailingZeroes2(int n) {
        int count = 0;
       for(int i = 5; i <= n; i = i*5){
           count += n/i;
       }
        return count;
    }
}
