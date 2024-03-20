package com.tamako.hash.intersection;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Author:Tamako
 * @Date:2024/2/15 10:11
 * @Description:349. 两个数组的交集
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hash = new HashSet<>();
        for (int i : nums1) {
            hash.add(i);
        }
        HashSet<Integer> res = new HashSet<>();
        for (int i : nums2) {
            if (hash.contains(i)) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
