package com.tamako.dp.bag.complete.coin_change_2;

/**
 * @Author:Tamako
 * @Date:2024/3/10 11:54
 * @Description:518. 零钱兑换 II
 */
public class Solution {

    //todo 求组合数
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;//起源不能为0
        for (int i = 0; i < coins.length; i++) {//遍历物品
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
