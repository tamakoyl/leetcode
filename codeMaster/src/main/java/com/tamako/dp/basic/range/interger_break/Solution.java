package com.tamako.dp.basic.range.interger_break;

/**
 * @Author:Tamako
 * @Date:2024/3/7 13:10
 * @Description:343. 整数拆分
 */
public class Solution {

    //todo 涉及到遍历区间！！
    // 递推公式!!
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i - j] * j, Math.max(dp[i], j * (i - j)));
            }
        }
        return dp[n];
    }
}
