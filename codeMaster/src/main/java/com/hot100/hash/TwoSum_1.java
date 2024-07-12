package com.hot100.hash;

import java.util.HashMap;

/**
 * @Author:Tamako
 * @Date:2024/7/12 14:31
 * @Description:1. 两数之和
 */
public class TwoSum_1 {
    public static void main(String[] args) {


    }

    //map<num,index>
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
        }
        return res;
    }
}
