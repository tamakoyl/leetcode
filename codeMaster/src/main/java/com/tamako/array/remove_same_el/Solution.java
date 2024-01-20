package com.tamako.array.remove_same_el;

/**
 * @Author:Tamako
 * @Date:2023/4/21 10:11
 * @Description:27. 移除元素
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 2};
        new Solution().removeElement(nums, 3);
    }

    public int removeElement(int[] nums, int val) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            //不同val的元素，与left相交换
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
