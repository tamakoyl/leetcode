package com.tamako.greedy.a_bit_hard.gas_station;

/**
 * @Author:Tamako
 * @Date:2024/3/2 17:15
 * @Description:134. 加油站
 */
public class Solution {


    //todo 贪心策略：[学习思想]
    // 优先选择出现 gas[i]-cost[i]>0 的点上车
    // 一旦curSum<0 上车位置i+1
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0, totalSum = 0, startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            int remain = gas[i] - cost[i];
            curSum += remain;
            totalSum += remain;
            if (curSum < 0) {
                curSum = 0;
                startIndex = i + 1;
            }
        }
        //如果totalSum <0 不可能绕一圈的
        if (totalSum < 0) {
            return -1;
        }
        return startIndex;
    }
}
