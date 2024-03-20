package com.tamako.dp.stock.sell_4;

/**
 * @Author:Tamako
 * @Date:2024/3/13 11:47
 * @Description:188.买卖股票的最佳时机IV
 */
public class Solution {
    //  初始化
    public int maxProfit(int k, int[] prices) {
        // 初始化
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 0; i <= 2 * k; i++) {
            if (i % 2 == 1) {
                dp[0][i] = -prices[0];
            }
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][2 * j - 1] = Math.max(dp[i - 1][2 * j - 1], dp[i - 1][2 * j - 2] - prices[i]);
                dp[i][2 * j] = Math.max(dp[i - 1][2 * j], dp[i - 1][2 * j - 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }

    public static void main(String[] args) {
        int [] prices = {3,3,5,0,0,3,1,4};
        int k = 2;
        int res = new Solution().maxProfit(2, prices);
    }
}
