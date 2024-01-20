package com.tamako.december.three;

/**
 * @Author:Tamako
 * @Date:2023/12/3 09:48
 * @Description: 1423. 可获得的最大点数
 */
public class Solution3 {

    //可以将问题转化为找到cardPoints中长度为n-k的最小和的连续子数组
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int cardPoint : cardPoints) {
            sum += cardPoint;
        }
        return sum - findMinSumOfSubArray(cardPoints, cardPoints.length - k);
    }

    /**
     * 问题：找到长度数组array中长度为k的最小和的子数组
     * 解决：滑动窗口
     *
     * @param array
     * @param k
     * @return
     */
    public int findMinSumOfSubArray(int[] array, int k) {
        int minSum = 0;
        int sum = 0;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (i < k) {
                sum += array[i];
                minSum = sum;
            } else {
                sum += array[i];
                sum -= array[i - k];
                minSum = Math.min(minSum, sum);
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 1};
        int res = new Solution3().maxScore(array, 3);
    }
}
