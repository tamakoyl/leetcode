package com.tamako.nov.nineteen;

/**
 * @Author:Tamako
 * @Date:2023/11/19 13:50
 * @Description:689. 三个无重叠子数组的最大和
 */
public class MaxSumOfSubArrays {
    public int[] maxSumOfThreeSubArrays(int[] nums, int k) {
        int[] res = new int[3];
        int maxSum1 = 0;
        int maxSum12 = 0;
        int maxSumTotal = 0;
        int beginIndex1 = 0;
        int maxSum12BeginIndex1 = 0;
        int maxSum12BeginIndex2 = 0;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int i = 0; i < nums.length - 2 * k; i++) {
            sum1 += nums[i];
            sum2 += nums[i + k];
            sum3 += nums[i + 2 * k];
            if (i >= k - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    beginIndex1 = i - k + 1;
                }
                //beginIndex1 可能会变
                //记录满足前两个不重叠子数组只和最大的Index
                if (maxSum1 + sum2 > maxSum12) {
                    maxSum12 = sum2 + maxSum1;
                    maxSum12BeginIndex1 = beginIndex1;
                    maxSum12BeginIndex2 = i + 1;
                }
                //maxSum12BeginIndex1  maxSum12BeginIndex2可能会变
                //记录满足三个不重叠子数组只和最大的Index
                if (sum3 + maxSum12 > maxSumTotal) {
                    maxSumTotal = sum3 + maxSum12;
                    res[0] = maxSum12BeginIndex1;
                    res[1] = maxSum12BeginIndex2;
                    res[2] = i + 1 + k;
                }
                sum1 -= nums[i - k + 1];
                sum2 -= nums[i + 1];
                sum3 -= nums[i + k + 1];
            }
        }
        return res;
    }


    /**
     * 单个子数组的最大和：采用滑动窗口[子数组是连续的、子序列不一定是连续的]
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxSumOfOneSubArrays(int[] nums, int k) {
        int maxSum = 0;
        int beginIndex = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                if (sum > maxSum) {
                    maxSum = sum;
                    beginIndex = i - k + 1;
                }
                sum -= nums[i - k + 1];
            }
        }
        return beginIndex;
    }


    /**
     * 两个无重叠子数组的最大和：采用滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSumOfTwoSubArrays(int[] nums, int k) {
        int[] res = new int[2];
        int maxSum1 = 0;
        int maxSum12 = 0;
        int beginIndex1 = 0;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length - k; i++) {
            sum1 += nums[i];
            sum2 += nums[i + k];
            if (i >= k - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    beginIndex1 = i - k + 1;
                }
                if ( maxSum1 + sum2 > maxSum12) {
                    maxSum12 = sum2 + maxSum1;
                    res[0] = beginIndex1;
                    res[1] = i + 1;
                }
                sum1 -= nums[i - k + 1];
                sum2 -= nums[i + 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSumOfSubArrays maxSumOfSubArrays = new MaxSumOfSubArrays();
//        int[] nums = {1, 2, 3, 4, 5};
//        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int[] nums = {20,18,9,2,14,1,10,3,11,18};
        maxSumOfSubArrays.maxSumOfOneSubArrays(nums, 2);
        maxSumOfSubArrays.maxSumOfTwoSubArrays(nums, 2);
        maxSumOfSubArrays.maxSumOfThreeSubArrays(nums, 3);
    }
}
