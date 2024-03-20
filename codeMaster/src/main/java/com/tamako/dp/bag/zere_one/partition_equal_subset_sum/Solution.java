package com.tamako.dp.bag.zere_one.partition_equal_subset_sum;


/**
 * @Author:Tamako
 * @Date:2024/3/9 08:59
 * @Description:416. 分割等和子集
 */
public class Solution {

    //todo 回溯会超时
    // 排序+双指针 没考虑到所有情况
    // 上0-1背包
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //奇数不能平分
        if (sum % 2 == 1) {
            return false;
        }
        int cap = sum  / 2;
        int[] dp = new int[cap + 1];
        for (int i = 0; i < nums.length; i++) {//遍历物品
            for (int j = cap; j >= nums[i]; j--) {//遍历背包
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[cap] == cap;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        boolean res = new Solution().canPartition(nums);
    }
}
