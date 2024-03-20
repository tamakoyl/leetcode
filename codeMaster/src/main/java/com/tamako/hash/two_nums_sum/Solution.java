package com.tamako.hash.two_nums_sum;

import java.util.HashMap;

/**
 * @Author:Tamako
 * @Date:2024/2/16 11:59
 * @Description:1. 两数之和
 */
public class Solution {

    //暴力解法
    //时间复杂度：O(n^2)
    public int[] twoSum(int[] nums, int target) {
        int[] res  = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] == n){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    //todo 没有直接想到用hash来解决喃
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (hashMap.containsKey(n)){
                res[0] = i;
                res[1] = hashMap.get(n);
            }else {
                hashMap.put(nums[i],i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] res = new Solution().twoSum(nums, 6);
    }
}
