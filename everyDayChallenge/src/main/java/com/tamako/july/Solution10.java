package com.tamako.july;

import java.util.*;

/**
 * @Author:Tamako
 * @Date:2023/7/10 12:47
 * @Description:16. 最接近的三数之和
 */
public class Solution10 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0};
        int res = new Solution10().threeSumClosest(nums, -100);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int threeSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            int curThreeSum = nums[i] + nums[j] + nums[k];
            while (j < k) {
                if (Math.abs(curThreeSum - target) < Math.abs(threeSum - target)) {
                   threeSum = curThreeSum;
                }
                if (curThreeSum == target) {
                    return target;
                } else if (curThreeSum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return threeSum;
    }
}
