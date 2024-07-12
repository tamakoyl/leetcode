package com.tamako.dp.subsequence.palindromic;

/**
 * @Author:Tamako
 * @Date:2024/3/25 14:57
 * @Description:647. 回文子串
 */
public class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {// a or ab是回文串
                        dp[i][j] = true;
                        cnt++;
                    } else if (dp[i + 1][j - 1]) {// b是 ->s[i]==s[j] 判断aba也是
                        cnt++;
                        dp[i][j] = true;
                    }
                }

            }
        }
        return cnt;
    }



    //dp

    //双指针法
}
