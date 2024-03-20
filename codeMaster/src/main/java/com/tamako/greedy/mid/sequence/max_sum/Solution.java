package com.tamako.greedy.mid.sequence.max_sum;

/**
 * @Author:Tamako
 * @Date:2024/2/29 13:19
 * @Description:53. 最大子序和
 */
public class Solution {

    //todo 贪心：当连续子序列的和<0 就直接从下一个开始累加
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            max = Math.max(sum,max);
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
