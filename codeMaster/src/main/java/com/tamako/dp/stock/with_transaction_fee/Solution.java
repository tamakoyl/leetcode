package com.tamako.dp.stock.with_transaction_fee;

/**
 * @Author:Tamako
 * @Date:2024/3/15 09:58
 * @Description:714. 买卖股票的最佳时机含手续费
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = - prices[0];
        dp[0][1] = 0;

        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][1] - prices[i],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0] + prices[i]-fee,dp[i-1][1]);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }
}
