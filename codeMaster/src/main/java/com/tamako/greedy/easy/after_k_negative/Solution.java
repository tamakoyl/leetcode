package com.tamako.greedy.easy.after_k_negative;

import java.util.Arrays;

/**
 * @Author:Tamako
 * @Date:2024/3/2 14:57
 * @Description:1005. K 次取反后最大化的数组和
 */
public class Solution {

    //贪心策略： k可以使k个负数变正
    //使绝对值大的负数变正
    //使绝对值小的正数变负
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int min = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }
        k = k % 2;
        if (k == 1) {
            flag = true;//还需要变负数
        }
        if (flag) {
            return sum - 2 * min;
        } else {
            return sum;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-8, 3, -5, -3, -5, -2};
        int res = new Solution().largestSumAfterKNegations(nums, 6);
    }
}
