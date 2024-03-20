package com.tamako.dp.bag.complete.combination_sum_4;

/**
 * @Author:Tamako
 * @Date:2024/3/10 12:21
 * @Description:377. 组合总和 Ⅳ
 */
public class Solution {
    // todo 求排列数
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {//背包容量
            for (int j = 0; j < nums.length; j++) {//物品
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
