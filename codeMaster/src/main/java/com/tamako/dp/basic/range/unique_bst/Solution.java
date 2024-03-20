package com.tamako.dp.basic.range.unique_bst;

/**
 * @Author:Tamako
 * @Date:2024/3/8 10:25
 * @Description:96. 不同的二叉搜索树
 */
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //初始化
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
