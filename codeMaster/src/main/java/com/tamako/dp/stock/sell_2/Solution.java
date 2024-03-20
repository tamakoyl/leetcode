package com.tamako.dp.stock.sell_2;

/**
 * @Author:Tamako
 * @Date:2024/3/13 11:46
 * @Description:122.买卖股票的最佳时机II
 */
public class Solution {

    public int maxProfit(int[] prices) {
        return dpSolution(prices);
    }

    //贪心思路：
    // 当收益是正的时候（买入和一直握着股票） ，负的就卖出去
    public int greedySolution(int [] prices){
        int profit = 0;
        if (prices.length == 0) {
            return profit;
        }
        int curDif = 0;
        for (int i = 1; i < prices.length; i++) {
            curDif = prices[i] - prices[i - 1];
            if (curDif > 0) {
                profit += curDif;
            }
        }
        return profit;
    }

    public int dpSolution(int [] prices){
        int[][] dp = new int[prices.length][2];
        //初始化
        //dp[i][1]:前i天持有股票
        //dp[i][0]:前i天不持有股票
        dp[0][1] = 0;
        dp[0][0] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] + prices[i], dp[i-1][1]);
        }
        return dp[prices.length-1][1];
    }
}
