package com.tamako.hash.ransom;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Tamako
 * @Date:2024/2/21 19:12
 * @Description:383. 赎金信
 */
public class Solution {
    //只需要对比每个字母出现的次数是否小于或者等于提供的字母
    //todo map要维护红黑树或者哈希表,所以遇见字母的hash要想着用数组
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineMap = new HashMap<>();
        HashMap<Character, Integer> ransomNoteMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            ransomNoteMap.put(ransomNote.charAt(i), ransomNoteMap.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : ransomNoteMap.entrySet()) {
            Character letter = entry.getKey();
            if (magazineMap.get(letter) == null || entry.getValue() > magazineMap.get(letter)) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] magazineMap = new int[26];
        int[] ransomNoteMap = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            magazineMap[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            ransomNoteMap[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ransomNoteMap[i] > magazineMap[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String magazine = "aab";
        String ransomNote = "aa";
        boolean res = new Solution().canConstruct(ransomNote, magazine);
    }
}
