package com.tamako.dp.bag.complete.coin_change_1;


/**
 * @Author:Tamako
 * @Date:2024/3/11 13:10
 * @Description:322. 零钱兑换
 */
public class Solution {
    public  int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //初始化
        dp[0] = 0;//todo dp[i]的含义！！
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {//物品
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {//这个细节注意一下，不是最大值才有选择的必要
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];//最后的细节
    }


}
