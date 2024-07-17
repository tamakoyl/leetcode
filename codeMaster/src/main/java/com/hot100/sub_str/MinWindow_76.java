package com.hot100.sub_str;

import java.util.HashMap;
import java.util.Map;

public class MinWindow_76 {
    public static void main(String[] args) {
        // String resString = minWindow("aa", "aa");
        String resString = minWindow("a", "a");
        // String resString = minWindow("ADOBECODEBANC", "ABC");

        System.out.println(resString);
    }

    public static String minWindow(String s, String t) {
        // 处理空值的情况
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 记录目标子串每个字符出现的频率
        Map<Character, Integer> tFreqMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreqMap.put(c, tFreqMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowFreqMap = new HashMap<>();
        int left = 0, right = 0;
        // 目标子串需要的字符的个数
        int required = tFreqMap.size();
        int formed = 0;

        int[] res = { -1, 0, 0 }; // (window length, left, right)

        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreqMap.put(c, windowFreqMap.getOrDefault(c, 0) + 1);

            // 如果滑动窗口内的相同字符的个数满足需要的个数，form++
            if (tFreqMap.containsKey(c) && windowFreqMap.get(c).intValue() == tFreqMap.get(c).intValue()) {
                formed++;
            }

            // 目标子串需要的字符的个数 == 当前滑动窗口目标子串的字符个数
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // 当滑动窗口长度更小时，更新答案
                // res[0] = -1是第一次满足条件时
                if (res[0] == -1 || right - left + 1 < res[0]) {
                    res[0] = right - left + 1;
                    res[1] = left;
                    res[2] = right;
                }

                // 记录完后滑动窗口left++
                // 如果当前c是目标子串中的字符，频次--
                windowFreqMap.put(c, windowFreqMap.get(c) - 1);
                // form--
                if (tFreqMap.containsKey(c) && windowFreqMap.get(c).intValue() < tFreqMap.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            // 不满足则滑动窗口right++
            right++;
        }

        return res[0] == -1 ? "" : s.substring(res[1], res[2] + 1);
    }

}
