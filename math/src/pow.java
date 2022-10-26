public class pow {

    public double myPow2(double x, int n) {
        /*
         * recursive
         * time log(n)
         * space 1
         */
        if(n == 0){
            return 1;
        }
        if( x == 0){
            return 0;
        }
        if(n < 0){
            x = 1/x;
            return (n %2 == 0) ? myPow(x*x, -(n/2)) : x*myPow(x*x, -(n/2));
        }
        
        return (n%2== 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }

    public double myPow(double x, int n) {
        /*!
         * iterative
         * time logn
         * space 1
         */
        double ans = 1;
        long absN = Math.abs((long)n);
        while( absN > 0){
            if((absN&1) == 1){
                ans*=x;
            }
            absN >>= 1;
            x = x*x;
        }
        
        return n < 0 ? 1 / ans : ans;
    }
    
}
