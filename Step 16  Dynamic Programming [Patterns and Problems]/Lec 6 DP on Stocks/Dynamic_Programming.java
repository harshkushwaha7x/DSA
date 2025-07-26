// Best Time to Buy and Sell Stock

class Solution {
    public int maxProfit(int[] prices) {
        int buy_price = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0;i<prices.length;i++) {
            if(buy_price<prices[i]) {
                int profit = prices[i] - buy_price;
                maxProfit = Math.max(profit,maxProfit);
            }
            else {
                buy_price = prices[i];
            }
        }
        return maxProfit;
    }
}

// Best Time to Buy and Sell Stock II

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}

// Best Time to Buy and Sell Stock III

class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE; int buy2 = Integer.MIN_VALUE;
        int sell1 = 0; int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, price+buy1);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, price + buy2);
        }

        return sell2;
    }
}

// Best Time to Buy and Sell Stock IV

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];
        for(int i=0; i<=k; i++){
            dp[0][i][1] -= prices[0];
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<=k; j++){
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        int ans = 0;
        for(int i=0; i<=k; i++){
            ans = Math.max(ans,dp[n-1][i][0]);
        }
        return ans;
    }
}

// Best Time to Buy and Sell Stock with Cooldown

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int length = prices.length;
        int[] buy = new int[length + 1];
        int[] sell = new int[length + 1];
        buy[1] = -prices[0];
        for (int i = 2; i <= length; i++) {
            int price = prices[i - 1];
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - price);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + price);
        }
        return sell[length];
    }
}