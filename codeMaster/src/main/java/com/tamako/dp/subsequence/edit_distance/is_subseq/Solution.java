package com.tamako.dp.subsequence.edit_distance.is_subseq;

/**
 * @Author:Tamako
 * @Date:2024/3/19 17:05
 * @Description:392. 判断子序列
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        // return editDistanceWay(s, t);
        return twoPointerWay(s,t);
    }

    public boolean twoPointerWay(String s,String t){
        int i = 0, j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i == s.length();

    }

    public boolean editDistanceWay(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];// 删除t(j-1)
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }

    // 最长公共子序列长度是否等于s的长度
    // todo 比较取巧了
    public boolean maxCommonSub(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        int max = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }
}
