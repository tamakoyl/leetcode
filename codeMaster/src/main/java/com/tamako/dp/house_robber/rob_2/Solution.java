package com.tamako.dp.house_robber.rob_2;

/**
 * @Author:Tamako
 * @Date:2024/3/13 10:17
 * @Description:213. 打家劫舍 II
 */
public class Solution {

    // todo 代码实现，和特殊测试用例的考虑
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int res1 = robMax(0, nums.length - 2, nums);//考虑第一个，就不考虑最后一个
        int res2 = robMax(1, nums.length - 1, nums);//考虑最后一个，就不考虑第一个
        return Math.max(res1, res2);
    }

    public int robMax(int start, int end, int[] nums) {
        if(start == end){
            return nums[start];//n=2的情况
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }
}
