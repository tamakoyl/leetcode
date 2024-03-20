package com.tamako.backtracking.combinition.letter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/23 17:03
 * @Description:17. 电话号码的字母组合
 */
public class Solution {

    private HashMap<Character, String> letterMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return res;
        }
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");
        backtracking( digits, 0);
        return res;
    }

    private StringBuilder path = new StringBuilder();
    private ArrayList<String> res = new ArrayList<>();

    private void backtracking(String digits, int s) {
        //bounding
        //递归出口
        if (path.length() == digits.length()) {
            res.add(new String(path));
            return;
        }
        for (int i = s; i < digits.length(); i++) {
            for (int j = 0; j < letterMap.get(digits.charAt(i)).length(); j++) {
                path.append(letterMap.get(digits.charAt(i)).charAt(j));
                backtracking(digits, i + 1);//递归
                path.deleteCharAt(path.length() - 1);//回溯
            }
        }
    }


}
