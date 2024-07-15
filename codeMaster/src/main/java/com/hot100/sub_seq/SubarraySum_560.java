package com.hot100.sub_seq;

import java.util.HashMap;

public class SubarraySum_560{
    public static void main(String[] args) {

    }

    // 枚举
    // 从后往前枚举
    // 可以减少重复计算
    public int subarraySum(int[] nums, int k) {
        int sum = 0, cnt = 0;
        for (int r = 0; r < nums.length; r++) {
            sum = 0;
            for (int l = r; l >= 0; l--) {
                sum += nums[l];
                if (sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 枚举
    // 采用前缀和来优化
    // 其实问题可以转变为，求两个连续数组前缀和的差为k
    public int subarraySum2(int[] nums, int k) {
        int sum = 0, cnt = 0;
        // key:preSum
        // val:前缀和出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);// 初始化前缀和为0，出现次数为1
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                cnt += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return cnt;
    }

}
