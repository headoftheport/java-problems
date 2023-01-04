public class TribonacciNumber {
    
    public int tribonacci(int n) {
        
        if(n == 0) 
            return 0;
        if(n == 1 || n == 2) 
            return 1;
        
        int[] store = new int[n+1];
        store[1] = 1;
        store[2] = 1;
            
        for(int i = 3; i <=n; i++){
            store[i] = store[i-1] + store[i-2] + store[i-3];
        }
        
        return store[n];
               
    }


    public int tribonacciRecur(int n) {

        int[] dp = new int[n+1];
        return recur(n, dp);

    }


    public int recur(int n, int[] dp) {

        if(n == 0) 
           return 0;
        if(n == 1 || n == 2) 
           return 1;
        if(dp[n] > 0)
           return dp[n];

        dp[n] = recur(n-1, dp) + recur(n-2, dp) + recur(n-3, dp);

        return dp[n];

    }
}
