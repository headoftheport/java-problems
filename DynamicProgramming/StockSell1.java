package DynamicProgramming;

public class StockSell1 {

    public int maxProfit(int[] prices) {
        /*
         * time complexity: O(n)
         * space complexity: O(n)
         */
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int profit[] = new int[prices.length];
        profit[0] = 0;
        profit[1] = Math.max(0, prices[1]-prices[0]);
        int maxDiff = -prices[0];
        for(int i=1; i<prices.length; i++){
            
            if(i >= 2){
                profit[i] = Math.max(profit[i-1], maxDiff + prices[i]);
                maxDiff = Math.max(maxDiff, profit[i-2] - prices[i]);
            }
            else{
                maxDiff = Math.max(maxDiff, -prices[i]);
            }
        }
        
        return profit[prices.length-1];
    }

    public int maxProfit2(int[] prices) {
        /*
         * time complexity: O(n)
         * space complexity: O(3n)
         */
        int[] rest = new int[prices.length];
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        
        rest[0] = 0;
        buy[0] = -prices[0];
        sell[0] = Integer.MIN_VALUE;
        
        for(int i = 1; i < prices.length; i++){
            rest[i] = Math.max(rest[i-1], sell[i-1]);
            buy[i] = Math.max(buy[i-1], rest[i-1]-prices[i]);
            sell[i] = buy[i-1] + prices[i];
        }
        
        return Math.max(rest[prices.length-1], sell[prices.length-1]);
    }

    public int maxProfit3(int[] prices) {
        /*
         * time complexity: O(n)
         * space complexity: O(1)
         */
        
        int rest = 0;
        int buy = -prices[0];
        int sell = Integer.MIN_VALUE;
        
        for(int i = 1; i < prices.length; i++){

            int prevSell = sell;
            sell = buy + prices[i];
            buy = Math.max(buy, rest-prices[i]);
            rest = Math.max(rest, prevSell);
        }
        
        return Math.max(rest, sell);
    }



    
}
