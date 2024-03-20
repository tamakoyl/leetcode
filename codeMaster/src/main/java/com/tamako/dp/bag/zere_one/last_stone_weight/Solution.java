package com.tamako.dp.bag.zere_one.last_stone_weight;

/**
 * @Author:Tamako
 * @Date:2024/3/9 10:23
 * @Description:1049. 最后一块石头的重量 II
 */
public class Solution {
    //回溯会超时
    // todo 转化成01背包问题
    //时间复杂度：O(m × n) , m是石头总重量（准确的说是总重量的一半），n为石头块数
    //空间复杂度：O(m)
    public int lastStoneWeightII(int[] stones) {
        int sumWeight = 0;
        for (int i = 0; i < stones.length; i++) {
            sumWeight+=stones[i];
        }
        int halfWeight = sumWeight/2;
        int[] dp = new int[halfWeight + 1];
        for (int i = 0; i < stones.length; i++) {//遍历物品
            for (int j = halfWeight; j >= stones[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return Math.abs(sumWeight-2*dp[halfWeight]);
    }
}
