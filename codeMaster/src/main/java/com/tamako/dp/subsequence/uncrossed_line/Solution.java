package com.tamako.dp.subsequence.uncrossed_line;

/**
 * @Author:Tamako
 * @Date:2024/3/19 16:43
 * @Description:1035. 不相交的线
 * todo 和求最长公共子序列一样呀！！！
 */
public class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int max = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];//todo 最后的opt 解
    }
}
