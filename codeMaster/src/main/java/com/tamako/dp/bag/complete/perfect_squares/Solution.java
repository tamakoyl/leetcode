package com.tamako.dp.bag.complete.perfect_squares;

/**
 * @Author:Tamako
 * @Date:2024/3/12 11:09
 * @Description:279. 完全平方数
 */
public class Solution {
    // todo 遍历顺序都可以
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <=n ; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i*i <=n ; i++) {//物品
            for (int j = i*i; j <=n ; j++) {//遍历容量
//                if(dp[j-i*i] != Integer.MAX_VALUE){  todo //因为必定会有解，全由1组成，所以不需要这一行判断
                    dp[j] = Math.min(dp[j],dp[j-i*i]+1);
//                }
            }
        }
        return dp[n];
    }
}
