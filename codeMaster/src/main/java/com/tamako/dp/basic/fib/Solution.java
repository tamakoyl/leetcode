package com.tamako.dp.basic.fib;

/**
 * @Author:Tamako
 * @Date:2024/3/7 09:49
 * @Description:509. 斐波那契数
 */
public class Solution {

    //1.dp[i]: fib(i)的值
    //2. 初始化:dp[0]=0 dp[1]=1
    //3. 递推: dp[i] = dp[i-1]+dp[i-2]
    //4. 遍历顺序: 从前往后
    public int fib(int n) {
        if(n <=1){
            return n;
        }
        int[] dp = new int[n];
        dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
