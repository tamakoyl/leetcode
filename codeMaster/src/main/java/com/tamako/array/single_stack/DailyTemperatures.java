package com.tamako.array.single_stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author:Tamako
 * @Date:2023/5/31 14:28
 * @Description:739. 每日温度
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = new DailyTemperatures().dailyTemperatures(temps);
        System.out.println(Arrays.toString(res));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> st = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            //当前temp大于栈顶序号的temp,更新res
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                res[st.peek()] = i - st.peek();
                st.pop();
            }
            //当前temp小于等于栈顶序号的temp，则入栈
            st.push(i);
        }
        return res;
    }
}
