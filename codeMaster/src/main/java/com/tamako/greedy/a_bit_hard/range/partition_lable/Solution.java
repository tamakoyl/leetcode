package com.tamako.greedy.a_bit_hard.range.partition_lable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/3/5 12:30
 * @Description:763. 划分字母区间
 */
public class Solution {

    //思路：遍历一边字符串，记录每个字母出现的最早index和最晚的index
    // 这样就类似 重叠区间的题了
    // 但是操作 比较繁琐呀
    public List<Integer> partitionLabels2(String s) {
        ArrayList<Integer> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }
        int[][] record = new int[26][2];
        HashSet<Character> hash = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!hash.contains(cur)) {
                record[cur - 'a'][0] = i;
                hash.add(cur);
            }
            record[cur - 'a'][1] = i;
        }
        //todo 除去没有出现的字母
        Arrays.sort(record, (a, b) -> Integer.compare(a[1], b[1]));
        int minRight = record[0][1];
        for (int i = 0; i < record.length; i++) {
            if (record[i][0] > minRight) {
                res.add(record[i][1] - record[i][0] + 1);
                minRight = record[i][1];//更新为结束的地方
            }
        }
        return res;
    }

    //todo 直接模拟法
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] maxOccurIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            maxOccurIndex[cur - 'a'] = i;
        }

        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            r = Math.max(r,maxOccurIndex[s.charAt(i)-'a']);
            if(i == r){
                res.add(r-l+1);
                l = i+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = new Solution().partitionLabels(s);
    }
}
