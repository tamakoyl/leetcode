package com.tamako.dp.subsequence.longest_increasing_serial_sub;

import java.util.Arrays;

/**
 * @Author:Tamako
 * @Date:2024/3/18 14:52
 * @Description:674. 最长连续递增序列
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        //todo 初始化dp[i] = 1
        Arrays.fill(dp,1);
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
