package com.tamako.dp.subsequence.max_sub_array;

/**
 * @Author:Tamako
 * @Date:2024/3/19 17:02
 * @Description:53. Maximum Subarray
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        return dpSolution(nums);
    }

    public int dpSolution(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        // 初始化
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // todo 贪心：当连续子序列的和<0 就直接从下一个开始累加
    public int greedySolution(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
