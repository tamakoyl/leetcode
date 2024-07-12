package com.tamako.dp.subsequence.edit_distance.distinct_subseq;

/**
 * @Author:Tamako
 * @Date:2024/3/20 15:54
 * @Description:115.不同的子序列
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // 初始化
        for (int j = 1; j <= t.length(); j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];//edit(s)
                } else {
                    dp[i][j] = dp[i - 1][j];//edit(s)
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
