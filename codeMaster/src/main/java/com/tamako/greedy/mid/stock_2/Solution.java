package com.tamako.greedy.mid.stock_2;

/**
 * @Author:Tamako
 * @Date:2024/3/1 10:31
 * @Description:122. 买卖股票的最佳时机 II
 */
public class Solution {

    //贪心思路：
    // 当收益是正的时候（买入和一直握着股票） ，负的就卖出去
    // 也就是只收集正利润了
    public int maxProfit(int[] prices) {
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
}
