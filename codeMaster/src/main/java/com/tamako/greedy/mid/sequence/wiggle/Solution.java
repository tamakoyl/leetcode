package com.tamako.greedy.mid.sequence.wiggle;

/**
 * @Author:Tamako
 * @Date:2024/2/29 12:29
 * @Description:376. 摆动序列
 */
public class Solution {
    //todo 思路！！！
    // 是一个optimization problem
    // 收集 feasible sub solution
    // 怎么由局部最优 -> 整体最优
    // 收集摇摆的子序列 -> 最长的摇摆子序列
    // 怎么模拟！！使用preDif和curDif
    // 边界的问题！！！！
    // todo 考虑 有 平的地方出现
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int cnt = 1;
        int preDif = 0,curDif=0;
        for (int i = 1; i < nums.length; i++) {
            curDif = nums[i] - nums[i - 1];
            if (curDif > 0 && preDif <= 0 || curDif < 0 && preDif >= 0) {
                cnt++;
                preDif = curDif;// 收集摇摆的子序列，更新
            }
        }
        return cnt;
    }
}
