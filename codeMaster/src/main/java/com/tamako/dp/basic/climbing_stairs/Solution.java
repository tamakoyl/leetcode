package com.tamako.dp.basic.climbing_stairs;

/**
 * @Author:Tamako
 * @Date:2024/3/7 10:00
 * @Description:70. 爬楼梯
 */
public class Solution {
    //1.dp[i]: 爬i阶楼梯有dp[i]种方法
    //2. 初始化:dp[1]=1 dp[2]=2
    //3. 递推: dp[i] = dp[i-1]+dp[i-2]
    //4. 遍历顺序: 从前往后
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2]= 2;
        for (int i = 3; i <=n ; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
