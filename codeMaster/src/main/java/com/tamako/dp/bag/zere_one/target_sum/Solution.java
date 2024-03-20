package com.tamako.dp.bag.zere_one.target_sum;

/**
 * @Author:Tamako
 * @Date:2024/3/9 11:28
 * @Description:494. 目标和
 */
public class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (Math.abs(target) > sum) {
            return 0;
        }
        //cap需要是正整数
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        int cap = (sum + target) / 2;
        int[] dp = new int[cap + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = cap; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[cap];
    }
}
