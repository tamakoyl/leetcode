package com.tamako.dp.stock.sell_1;

import java.util.*;

/**
 * @Author:Tamako
 * @Date:2024/3/13 11:44
 * @Description:121. 买卖股票的最佳时机
 */
public class Solution {

    public int maxProfit(int[] prices) {
        //    return bruteForce(prices);
        // return greedySolution(prices);
        return dpSolution(prices);
    }

    //暴力：找到max(prices[i] - price[j])
    public int bruteForce(int[] prices){
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i+1; j< prices.length;j++){
                max = Math.max(prices[j]-prices[i],max);
            }
        }
        return max;
    }

    //贪心：从左边找最小的，从右边找最大的
    public int greedySolution(int[] prices){
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min,prices[i]);
            res = Math.max(prices[i]-min,res);
        }
        return res;
    }

    //dp
    public int dpSolution(int[] prices){
        int[][] dp = new int[prices.length][2];
        //初始化
        //dp[i][1]:前i天持有股票
        //dp[i][0]:前i天不持有股票
        dp[0][1] = 0;
        dp[0][0] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] + prices[i], dp[i-1][1]);
        }
        return dp[prices.length-1][1];
    }




}
