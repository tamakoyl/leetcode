package com.tamako.May.thirteen;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Tamako
 * @Date:2023/4/13 08:14
 * @Description: 2404. 出现最频繁的偶数元素
 */
public class Solution {
    public static void main(String[] args) {
        int res = new Solution().mostFrequentEven(new int[]{0, 1, 2, 2, 4, 4, 1});
        System.out.println(res);
    }


    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int times;
        for (int num : nums) {
            if (frequencyMap.containsKey(num) && num % 2 == 0) {
                times = frequencyMap.get(num) + 1;
                frequencyMap.put(num, times);
            } else {
                frequencyMap.put(num, 1);
            }
        }
        int maxFreq = 0;
        int res = -1;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            Integer num = entry.getKey();
            if (((entry.getValue() > maxFreq) || (entry.getValue() == maxFreq && res > num))) {
                maxFreq = entry.getValue();
                res = num;
            }
        }
        return res;
    }
}
