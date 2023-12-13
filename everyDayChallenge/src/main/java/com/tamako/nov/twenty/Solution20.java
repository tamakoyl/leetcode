package com.tamako.nov.twenty;

/**
 * @Author:Tamako
 * @Date:2023/11/20 09:21
 * @Description: 53. 最大子数组和
 */
public class Solution20 {

    /**
     * dp
     * 1.定义：以dp[i]为以i结尾的子数组的最大和
     * 2.递推：
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (dp[i] > 0) {
                dp[i + 1] = dp[i] + nums[i + 1];
            } else {
                dp[i + 1] = nums[i + 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int sum : dp) {
            max = Math.max(sum, max);
        }
        return max;
    }

    /**
     * 前缀和
     *
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {

        return 0;
    }

    /**
     * 分治
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {


        return 0;
    }



//    public int getCrossingMaxSum(int ){
//
//    }

    /**
     * 以nums[r]结尾的最大子数组和
     * @param nums
     * @param l
     * @param r
     */
    public int getLeftMaxSum(int nums[], int l, int r) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = r; i >= l; i--) {
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * 以nums[l]开始的最大子数组和
     * @param nums
     * @param l
     * @param r
     */
    public int getRightMaxSum(int nums[], int l, int r) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-1};
        Solution20 solution20 = new Solution20();
        int res = solution20.maxSubArray(nums);
    }
}
