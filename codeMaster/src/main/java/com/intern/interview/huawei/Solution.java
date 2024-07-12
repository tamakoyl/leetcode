package com.intern.interview.huawei;

import java.util.HashSet;

/**
 * @Author:Tamako
 * @Date:2024/4/28 15:21
 * @Description:给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 *                      示例 1:
 *                      输入: s = "abcabcbb"
 *                      输出: 3
 *                      解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *                      示例 2:
 *                      输入: s = "bbbbb"
 *                      输出: 1
 *                      解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *                      示例 3:
 *                      输入: s = "pwwkew"
 *                      输出: 3
 *                      解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *                      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *                      示例 4:
 *                      输入: s = ""
 *                      输出: 0
 *
 *                      提示：
 *
 *                      0 <= s.length <= 5 * 104
 *                      s 由英文字母、数字、符号和空格组成
 */
public class Solution {
    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2 = "bbbb";
        String s3 = "pwwkew";
        int res = new Solution().maxUniqueSubstrLen("");
        System.out.println(res);
    }

    // 使用滑动窗口解决
    public int maxUniqueSubstrLen(String s) {
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        int r = -1, res = 0;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (r + 1 < len && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(r + 1));
                ++r;
            }
            res = Math.max(res, r - i + 1);
        }
        return res;
    }
}
