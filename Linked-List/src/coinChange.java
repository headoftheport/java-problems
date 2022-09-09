import java.util.Arrays;

public class coinChange {

    public int coinChange1(int[] coins, int amount) {
        /*
         * bottom up using iterative approach and memo
         * time complexity O(amount * number of coins)
         * space complexity O(amount)
         */
        int max = amount + 1;
        int[] count = new int[amount+1];
        Arrays.fill(count, max);
        count[0] = 0;    
        for(int i = 1; i <= amount; i++){
            for(int coin: coins){
                if(coin <= i){
                    count[i] = Math.min(count[i], count[i-coin]+1);
                }
            }
        }
        return count[amount] > amount ? -1: count[amount];
                 
    }


    public int coinChange(int[] coins, int amount) {

        /*
         * top down using recurssion and memo
         * time complexity O(amount * number of coins)
         * space complexity O(amount)
         */
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count){
        
        if(rem < 0) return -1;
        if(rem == 0) return 0;
        if(count[rem-1] != 0) return count[rem-1];
        int min = Integer.MAX_VALUE;
        for(int coin: coins){
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min){
                min = res + 1;
            }
        }
        count[rem-1] = (min == Integer.MAX_VALUE) ? -1: min;
        return count[rem-1];
            
    }
    
}
