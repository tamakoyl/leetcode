package com.tamako.greedy.a_bit_hard.range.non_overlapping_interval;

import java.util.Arrays;

/**
 * @Author:Tamako
 * @Date:2024/3/5 12:00
 * @Description:435. 无重叠区间
 */
public class Solution {

    //贪心思路:
    // todo 类似 活动安排！！！
    //最晚结束活动时间
    public int eraseOverlapIntervals(int[][] intervals) {
        //已经区间的右边界进行排序
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        if(intervals.length == 0){
            return 0;
        }
        int cnt = 0;
        int minRight = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= minRight){
                cnt++;
                minRight = intervals[i][1];
            }
        }
        return intervals.length-cnt;
    }
}
