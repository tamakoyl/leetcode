package com.tamako.hash.group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/4/8 09:02
 * @Description:49. 字母异位词分组
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        //todo 异位的单词怎样获得相同的key:排序
        for (String word : strs) {
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String sortedWord = new String(wordArray);
            List<String> list = map.getOrDefault(sortedWord, new ArrayList<>());
            list.add(word);
            map.put(sortedWord,list);
        }
        return new ArrayList<>(map.values());
    }


}
