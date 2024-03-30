package com.tamako.dp.subsequence.longest_increasing_sub;

import java.util.Arrays;

/**
 * @Author:Tamako
 * @Date:2024/3/17 10:06
 * @Description:300. 最长递增子序列
 */
public class Solution {
    //todo 要考虑区间
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        //初始化：dp[i]至少是1
        Arrays.fill(dp,1);
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
