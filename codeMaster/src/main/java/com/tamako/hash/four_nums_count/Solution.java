package com.tamako.hash.four_nums_count;

import java.util.HashMap;

/**
 * @Author:Tamako
 * @Date:2024/2/20 13:02
 * @Description:454. 四数相加 II
 */
public class Solution {
    //todo 正常的模拟就可以了 思路很重要！！
    //不需要考虑去重
    //时间复杂度：O(n^2)
    //空间复杂度: O(1)
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int cnt = 0;
        //两数只和
        //key: sum
        //val: frequency
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                sumMap.put(nums1[i] + nums2[j], sumMap.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (sumMap.containsKey(-(nums3[i] + nums4[j]))) {
                    cnt += sumMap.get(-(nums3[i] + nums4[j]));
                }
            }
        }
        return cnt;
    }
}
