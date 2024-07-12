package com.hot100.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LongestConsecutive_128 {
    public static void main(String[] args) {
        int res = longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 });
    }

    // 思路：
    // 1.hash去重
    // 2.排序
    // 3.计数
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        ArrayList<Integer> uniqueList = new ArrayList<>(set);
        if (uniqueList.size() <= 1)
            return uniqueList.size();
        Collections.sort(uniqueList);
        int cnt = 1;
        int res = 1;
        System.out.println(uniqueList);
        for (int i = 1; i < uniqueList.size(); i++) {
            if (uniqueList.get(i) - uniqueList.get(i - 1) == 1) {
                cnt++;
                res = Math.max(res, cnt);
            } else {
                cnt = 1;
                continue;
            }

        }

        return res;
    }

    // 思路：
    // 1.hash去重
    // 2.遍历每一个元素，开始从该元素e枚举，每次+1，判e+1是否在集合
    // 3.得到最长的连续数组
    public static int longestConsecutive2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int res = 1;
        int cur = 0;
        for (Integer e : set) {
            int cnt = 1;
            cur = e;
            while (set.contains(++cur)) {
                cnt++;
            }
            res = Math.max(res, cnt);
        }

        return res;
    }

    // 优化
    public static int longestConsecutive3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res = 0;
        int cur = 0;
        for (Integer e : set) {
            int cnt = 1;
            cur = e;
            // 从e+1不在set的位置开始枚举
            if (!set.contains(e + 1)) {
                while (set.contains(--cur)) {
                    cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
