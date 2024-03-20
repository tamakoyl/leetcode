package com.tamako.dp.bag.complete.climb_stairs;

/**
 * @Author:Tamako
 * @Date:2024/3/11 12:11
 * @Description: 爬楼梯[进阶版]
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬至多m (1 <= m < n)个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 输入描述：输入共一行，包含两个正整数，分别表示n, m
 * 输出描述：输出一个整数，表示爬到楼顶的方法数。
 * 输入示例：3 2
 * 输出示例：3
 * 当 m = 2，n = 3 时，n = 3 这表示一共有三个台阶，m = 2 代表你每次可以爬一个台阶或者两个台阶。
 * 此时你有三种方法可以爬到楼顶。
 * 1 阶 + 1 阶 + 1 阶段
 * 1 阶 + 2 阶
 * 2 阶 + 1 阶
 */
public class Solution {
    //排列问题
    // 背包容量：n
    //物品:[1,2...,m]
    public int climbStairs(int n,int m){
        int[] dp = new int[n + 1];
        for (int j = 0; j <=n ; j++) {//遍历背包容量
            for (int i = 0; i <= m; i++) {//遍历物品
                if(j>=i){
                    dp[j]+=dp[j-i];
                }
            }
        }
        return dp[n];
    }
}
