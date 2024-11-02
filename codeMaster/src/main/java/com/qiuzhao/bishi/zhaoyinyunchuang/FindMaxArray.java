package com.qiuzhao.bishi.zhaoyinyunchuang;

/**
 * @Author:Tamako
 * @Date:2024/9/11 21:19
 * @Description:TODO
 */
public class FindMaxArray {
    public static void main(String[] args) {
        int res = new FindMaxArray().FindGreatest(new int[]{3, 10, -4, 7, 2});
        System.out.println(res);
    }
    public int FindGreatest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int curSum = 0;
        int maxSum = 0;
        int maxNum = Integer.MIN_VALUE;

        // 找到数组中的最大值
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxNum) {
                maxNum = array[i];
            }
        }

        // 如果数组中的最大值小于等于0，返回最大值
        if (maxNum <= 0) {
            return maxNum;
        }

        // 使用Kadane's算法计算最大连续子数组和
        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0) {
                curSum = array[i];
            } else {
                curSum += array[i];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }

        return maxSum;
    }
}

