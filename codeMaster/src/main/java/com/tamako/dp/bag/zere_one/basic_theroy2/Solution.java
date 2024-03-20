package com.tamako.dp.bag.zere_one.basic_theroy2;

/**
 * @Author:Tamako
 * @Date:2024/3/8 15:07
 * @Description:01背包理论2
 */
public class Solution {
    //一维dp解决
    public int maxWeight(int capacity, int[] weight, int[] volume) {
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < weight.length; i++) {//遍历物品
            for (int j = capacity; j >=volume[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-volume[i]]+weight[i]);
            }
        }
        return dp[capacity];
    }

}
