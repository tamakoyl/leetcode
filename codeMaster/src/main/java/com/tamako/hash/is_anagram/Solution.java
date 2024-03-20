package com.tamako.hash.is_anagram;


/**
 * @Author:Tamako
 * @Date:2024/2/13 13:46
 * @Description:242. 有效的字母异位词
 */
public class Solution {
    //todo 自己写得稍微有点笨重  而且有个案例没有通过啊啊啊
    //
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphabetFreq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabetFreq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabetFreq[t.charAt(i) - 'a']--;
        }
        for (int j : alphabetFreq) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "car";
        String t = "rat";
        boolean res = new Solution().isAnagram(s, t);
    }
}
