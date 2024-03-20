package com.tamako.dp.basic.most_min_cost_climb_staris;

/**
 * @Author:Tamako
 * @Date:2024/3/7 10:23
 * @Description:746. 使用最小花费爬楼梯
 */
public class Solution {
    //1.dp[i]: 爬i阶楼梯最小花费是dp[i]
    //2. 初始化:dp[0]=0 dp[1]=0
    //3. 递推: dp[i] = min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
    //4. 遍历顺序: 从前往后
    // 最后返回dp[cost.length]
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];//todo cost[n-1] 还没到达呢！！
        dp[0] = 0;// todo 从0或1开始，所以到达0或1 话费为0
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
