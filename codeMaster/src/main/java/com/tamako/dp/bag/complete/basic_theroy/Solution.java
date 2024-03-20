package com.tamako.dp.bag.complete.basic_theroy;

/**
 * @Author:Tamako
 * @Date:2024/3/10 11:39
 * @Description:完全背包
 */
public class Solution {
    public void completePack() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < value.length; i++) {//遍历物品
            for (int j = weight[i]; j <= bagWeight; j++) {//容量从小到大，因为可以重复取物品
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
    }
}
