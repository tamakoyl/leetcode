package com.tamako.array.slide_win.length_of_longest_substring;

/**
 * @Author:Tamako
 * @Date:2024/4/10 09:41
 * @Description:3. 无重复字符的最长子串
 */
public class Solution {

    //使用双指针维护一个滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        int i = 0, j = 1, max = 0;
        while (j < s.length()) {
            if (s.charAt(j) == s.charAt(i)) {//头和尾元素相同向前滑动
                i++;
                j++;
            } else if (s.substring(i, j).indexOf(s.charAt(j)) == -1) {//当前元素不在窗口中
                j++;//右边界向右边滑动
            } else {//当前元素在滑动窗口中
                max = Math.max(max, j - i);//更新最大的窗口数
                i = s.substring(i, j).indexOf(s.charAt(j)) + i + 1;//将左窗口滑动到重复元素的后一个位置，注意一下+i的偏移量
                j = j + 1;
            }
        }
        return Math.max(max, j - i);
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = new Solution().lengthOfLongestSubstring(s);
    }
}
