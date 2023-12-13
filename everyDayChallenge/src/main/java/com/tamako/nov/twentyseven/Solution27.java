package com.tamako.nov.twentyseven;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author:Tamako
 * @Date:2023/11/27 09:39
 * @Description:907. 子数组的最小值之和
 */
public class Solution27 {
    /**
     * 单调栈+贡献度
     * @param arr
     * @return
     */
    public int sumSubArrMinMonotoneStack(int[] arr) {
        int len = arr.length;
        long minSum = 0;
        int[] leftLoc = new int[len];
        int[] rightLoc = new int[len];
        Deque<Integer> monotoneLeftStack = new LinkedList<>();
        Deque<Integer> monotoneRightStack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!monotoneLeftStack.isEmpty() && arr[monotoneLeftStack.peek()] >= arr[i]) {
                monotoneLeftStack.pop();
            }
            leftLoc[i] = monotoneLeftStack.isEmpty() ? -1 : monotoneLeftStack.peek();
            monotoneLeftStack.push(i);
            while (!monotoneRightStack.isEmpty() && arr[monotoneRightStack.peek()] > arr[len - i - 1]) {
                monotoneRightStack.pop();
            }
            rightLoc[len - i - 1] = monotoneRightStack.isEmpty() ? len : monotoneRightStack.peek();
            monotoneRightStack.push(len - i - 1);
        }

        for (int i = 0; i < len; i++) {
            minSum += (i - leftLoc[i]) * (rightLoc[i] - i) * arr[i];
        }

        return (int) (minSum % 1000000007L);
    }

    /**
     * 记忆化搜索超出空间限制了
     * 空间复杂度O(N^2)
     *
     * @param arr
     * @return
     */
    public int sumSubarrayMin(int[] arr) {
        int len = arr.length;
        long minSum = 0;
        //记录以memo[i][j]表示
        // arr[i]开头arr[j]结尾的连续子数组的min
        int[][] memo = new int[len][len];
        //初始化
        for (int i = 0; i < len; i++) {
            memo[i][i] = arr[i];
            minSum += arr[i];
        }
        for (int b = 2; b <= len; b++) {
            for (int i = 0; i + b - 1 < len; i++) {
                int min = Math.min(memo[i][i + b - 2], arr[i + b - 1]);
                memo[i][i + b - 1] = min;
                minSum += min;
            }
        }
        return (int) (minSum % 1000000007L);
    }

    public static void main(String[] args) {
//        int[] nums = {3, 1, 2, 4};
//        int[] nums = {11, 81, 94, 43, 3};
        int[] nums = {71, 55, 82, 55};
        int res = new Solution27().sumSubArrMinMonotoneStack(nums);
    }
}
