package com.tamako.array.sorted_squares;

import java.util.Arrays;

/**
 * @Author:Tamako
 * @Date:2023/12/19 10:10
 * @Description:977. 有序数组的平方
 */
public class Solution {

    //暴力
    //时间复杂度：O(n)+O(nlogn)
    //空间复杂度：O(1)
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];//O(n)
        }
        Arrays.sort(nums);//O(nlogn)
        return nums;
    }

    //双指针
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public int[] sortedSquares2(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;
        int[] res = new int[nums.length];
        while (i <= j) {
            if (Math.abs(nums[i]) >= Math.abs(nums[j])) {
                res[k--] = nums[i] * nums[i];
                i++;
            } else {
                res[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return res;
    }
}
