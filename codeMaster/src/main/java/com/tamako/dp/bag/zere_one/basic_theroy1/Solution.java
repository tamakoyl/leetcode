package com.tamako.dp.bag.zere_one.basic_theroy1;

/**
 * @Author:Tamako
 * @Date:2024/3/8 11:13
 * @Description: 01背包理论1
 */
public class Solution {


    public int maxWeight(int capacity, int[] weight, int[] volume) {
        int[][] dp = new int[weight.length][capacity + 1];
        //初始化
        //背包容量为0
        for (int i = 0; i <= capacity; i++) {
            dp[i][0] = 0;
        }
        //只放0号物品 todo 这个初始化！！！
        for (int j = weight[0]; j < weight.length; j++) {
            dp[0][j] = weight[0];
        }

        for (int i = 0; i <= capacity; i++) {
            for (int j = 0; j < weight.length; j++) {
                if (j >= volume[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - volume[i]] + weight[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weight.length - 1][capacity];
    }



}
