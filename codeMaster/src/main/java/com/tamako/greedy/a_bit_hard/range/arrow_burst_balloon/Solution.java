package com.tamako.greedy.a_bit_hard.range.arrow_burst_balloon;

import java.util.Arrays;

/**
 * @Author:Tamako
 * @Date:2024/3/5 09:01
 * @Description:452. 用最少数量的箭引爆气球
 */
public class Solution {

    //贪心策略：

    //todo 这个题的思路有点难啊啊啊啊！！边界也不好想！！
    // 还有就是 区别 i+1、i[当前元素和下一个元素]遍历和i、i-1遍历[当前元素和上一个元素]
    public int findMinArrowShots(int[][] points) {
        //按开始时间进行排序
        Arrays.sort(points, (a,b)-> Integer.compare(a[0],b[0]));

        if(points.length == 0){
            return 0;
        }
        int res = 1;//至少需要一支箭
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i-1][1]) {//如果气球重叠了，重叠气球中右边边界的最小值之前的区间一定需要一个弓箭，所以不包括'='
                res++;
            } else {
                points[i][1] = Math.min(points[i][1],points[i-1][1]);//更新为最小右边区间,更新的元素是points[i]
            }
        }
        return res;
    }

    public int findMinArrowShots2(int[][] points) {
        //按开始时间进行排序
        Arrays.sort(points, (a,b)-> Integer.compare(a[0],b[0]));

        if(points.length == 0){
            return 0;
        }
        int res = 1;//至少需要一支箭
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i+1][0] > points[i][1]) {//如果气球重叠了，重叠气球中右边边界的最小值之前的区间一定需要一个弓箭，所以不包括'='
                res++;
            } else {
                points[i+1][1] = Math.min(points[i][1],points[i+1][1]);//更新为最小右边区间,更新的元素是point[i+1]
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int res = new Solution().findMinArrowShots(points);
    }
}
