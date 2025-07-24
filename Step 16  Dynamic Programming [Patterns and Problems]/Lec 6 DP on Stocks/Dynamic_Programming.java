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