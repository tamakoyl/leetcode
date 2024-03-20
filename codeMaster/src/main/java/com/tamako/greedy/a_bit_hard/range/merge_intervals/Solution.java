package com.tamako.greedy.a_bit_hard.range.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author:Tamako
 * @Date:2024/3/6 09:22
 * @Description:56. 合并区间
 */
public class Solution {

    // 思路： 本质还是找重叠区间
    public int[][] merge(int[][] intervals) {
        //需要按照最早开始的时间sort
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> res = new ArrayList<>();
        if(intervals.length == 0){
            return res.toArray(new int[0][]);
        }
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > end){
                res.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }else {
                end = Math.max(end,intervals[i][1]);
            }
        }
        //加入最后一个区间
        res.add(new int[]{start,end});
        return res.toArray(new  int[0][]);
    }
}
