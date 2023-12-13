package com.tamako.May.twenty_seven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2023/4/27 10:21
 * @Description:1048. 最长字符串链
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        boolean res = solution.isPre("aaac", "aaacc");
    }
    public int longestStrChain(String[] words) {
        //key 长度
        HashMap<Integer, List<String>> wordsMap = new HashMap<>();
        for (String word :words) {
            int wordLen = word.length();
            if(wordsMap.get(wordLen) == null){
                ArrayList<String> temp = new ArrayList<>();
                temp.add(word);
                wordsMap.put(wordLen,temp);
            }else {
                List<String> temp = wordsMap.get(wordLen);
                temp.add(word);
                wordsMap.put(wordLen,temp);
            }
        }

       return 0;

    }


    boolean isPre(String pre, String cur) {
        char[] previous = pre.toCharArray();
        char[] current = cur.toCharArray();
        if (pre.length() + 1 != cur.length()) return false;
        int i = 0, j = 0;
        while (i < pre.length()) {
            if (current[j] != previous[i]) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        if(j == i | j-i == 1)return true;
        return false;
    }
}
