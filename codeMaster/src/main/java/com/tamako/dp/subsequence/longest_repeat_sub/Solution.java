package com.tamako.dp.subsequence.longest_repeat_sub;

/**
 * @Author:Tamako
 * @Date:2024/3/18 15:09
 * @Description:718. 最长重复子数组: 需要连续！！
 */
public class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];//todo 初始化！！
        //todo dp[0][j]和dp[i][0]没有意义
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //todo nums1[i-1]!=nums[j-1]没有意义,dp[i][j]定义就是nums1[i-1]==nums[j-1]
                    dp[i][j] = 0;//本来初始化就为0，所以可以省略
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
