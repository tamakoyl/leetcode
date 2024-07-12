package com.tamako.mono_stack.daily_temp;

import java.util.Stack;

/**
 * @Author:Tamako
 * @Date:2024/3/30 10:26
 * @Description:739. 每日温度
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.push(0);// len > 0，放index
        for (int i = 1; i < temperatures.length; i++) {
            //todo 注意这个地方
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }


}
