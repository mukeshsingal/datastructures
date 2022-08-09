package leetcode;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class Problem_122_Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i = 0; i < prices.length-1; i++) {
            if(prices[i] < prices[i+1]) {
                profit += prices[i+1] - prices[i];
            }
        }

        return profit;
    }
}
