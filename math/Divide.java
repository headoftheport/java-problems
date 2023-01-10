public class Divide {

    public int divide(int dividend, int divisor) {
            
        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;
        int a = Math.abs(dividend), b = Math.abs(divisor), res = 0;
        for (int x = 31; x >= 0; x--)
            if ((a >>> x) - b >= 0) {
                res += 1 << x;
                a -= b << x;
            }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }

    public int divide2(int dividend, int divisor) {
            
        if(dividend == divisor){
            return 1;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        
        boolean sign = (dividend < 0 == divisor < 0);
        
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int ans = 0;
        while ( a - b >= 0){
            int temp = b;
            int count = 1;
            while ( a - (temp << 1) >= 0){
                temp <<= 1;
                count <<= 1;
            }
            a -= temp;
            ans += count;
        }
       
        return sign ? ans: -ans;
    }
    
}
