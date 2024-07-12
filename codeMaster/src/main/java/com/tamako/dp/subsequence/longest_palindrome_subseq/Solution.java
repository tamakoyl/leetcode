package com.tamako.dp.subsequence.longest_palindrome_subseq;

/**
 * @Author:Tamako
 * @Date:2024/3/30 10:21
 * @Description:516. 最长回文子序列
 */
public class Solution {
    public int longestPalindromeSubSeq(String s) {
        //dp[i][j]：区间[i,j]的最长回文子序列的长度为dp[i][j]
        int[][] dp = new int[s.length()][s.length()];
        //初始化计算i==j的情况，因为递推不能计算这种情况
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {//j!=i
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
