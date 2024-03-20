package com.tamako.dp.stock.with_cooldown;


/**
 * @Author:Tamako
 * @Date:2024/3/15 09:57
 * @Description:309. 买卖股票的最佳时机含冷冻期
 */
public class Solution {
    public int maxProfit(int[] prices) {
        //逆天！！！！太难了吧！！！！
        /**
         dp[i][0] 持有股票
         (1)i-1天前就持有股票 dp[i-1][0]
         (2)i-1天前没有股票,第i天买入 dp[i-1][1]-prices[i]
         (3)i-1在冷冻期，第i天买入dp[i-1][3]-prices[i]
         不持有股票 有两种状态
         1. dp[i][1] 保持卖出状态
         (1) i-1也是卖出状态 dp[i-1][1]
         (2) i-1是冷冻状态dp[i-1][3]
         2.dp[i][2] 第i天卖出 dp[i-1][0]+prices[i]

         dp[i][3] 在冷冻期
         在第i-1天卖出，第i天在冷冻期 dp[i-1][2]
         */
        int len = prices.length;
        int[][] dp = new int[len][4];
        //初始化
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]), dp[i - 1][3] - prices[i]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][3] = dp[i - 1][2];
        }
        //持有股票状态肯定不是最大情况
        return Math.max(Math.max(dp[len - 1][1], dp[len - 1][2]), dp[len - 1][3]);
    }
}
