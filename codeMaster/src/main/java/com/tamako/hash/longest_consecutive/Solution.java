package com.tamako.hash.longest_consecutive;

import java.util.HashSet;

/**
 * @Author:Tamako
 * @Date:2024/4/8 09:56
 * @Description:128. 最长连续序列
 */
public class Solution {

    // 不能排序
    // 超时了！！！！
    public int longestConsecutiveOverTime(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }

        int cnt = 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            // 会重复计算1，2，3，4，5
            // 从1开始枚举 or 2，3，4，开始枚举，重复计算
            while (hashSet.contains(--cur)) {
                cnt++;
            }
            res = Math.max(res, cnt);
            cnt = 1;
        }
        return res;
    }

    // todo 怎样避免重复计算？？
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // 枚举一个不在hashSet的数作为起点，就不会重复计算了
            if (!hashSet.contains(nums[i] + 1)) {
                int cnt = 1;
                int cur = nums[i];
                while (hashSet.contains(--cur)) {
                    cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
