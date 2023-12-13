package com.tamako.nov.thirty;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author:Tamako
 * @Date:2023/11/30 09:38
 * @Description:1657. 确定两个字符串是否接近
 */
public class Solution30 {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character, Integer> word1CharacterTimesMap = new HashMap<>();
        HashMap<Character, Integer> word2CharacterTimesMap = new HashMap<>();
        StringBuilder stringBuilder1 = new StringBuilder(word1);
        StringBuilder stringBuilder2 = new StringBuilder(word2);
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 != len2) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            Character key = stringBuilder1.charAt(i);
            word1CharacterTimesMap.put(key, word1CharacterTimesMap.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < len2; i++) {
            Character key = stringBuilder2.charAt(i);
            word2CharacterTimesMap.put(key, word2CharacterTimesMap.getOrDefault(key, 0) + 1);
        }
        List<Integer> times1 = word1CharacterTimesMap.values().stream().sorted().collect(Collectors.toList());
        List<Integer> times2 = word2CharacterTimesMap.values().stream().sorted().collect(Collectors.toList());
        if (times2.size() != times1.size()) {
            return false;
        }

        List<Character> word1Character = word1CharacterTimesMap.keySet().stream().collect(Collectors.toList());
        //包含的字母是相同的
        for (Character c : word1Character) {
            if (!word2CharacterTimesMap.containsKey(c)) {
                return false;
            }
        }

        //字母出现的频数是相同的
        for (int i = 0; i < times1.size(); i++) {
            if (times1.get(i) - times2.get(i) != 0) {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        boolean res = new Solution30().closeStrings("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii", "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
    }
}
