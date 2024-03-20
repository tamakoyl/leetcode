package com.tamako.backtracking.partition.palindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/25 15:05
 * @Description:131.分割回文串
 */
public class Solution {
    //todo 整个思路还需要多思考一下
    private List<String> path = new ArrayList<>();
    private List<List<String>> res = new ArrayList<>();

    //bounding
    public List<List<String>> partition(String s) {
        backtracking(0, s);
        return res;
    }

    private void backtracking(int startIndex, String s) {
        //bounding func
        //递归出口处理的index大于s的长度 todo
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (palindrome(s, startIndex, i)) {//模拟切割线的方法[startIndex,i]获得子串
                path.add(s.substring(startIndex, i + 1));
                backtracking(i + 1, s);//递归 下一个character
                path.remove(path.size() - 1);//回溯
            }
        }

    }

    //判断s的子串[begin,end]是否为回文
    private boolean palindrome(String s, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
