package com.tamako.greedy.mid.two_dimension.dispatch_candy;

/**
 * @Author:Tamako
 * @Date:2024/3/4 06:58
 * @Description:135. 分发糖果
 */
public class Solution {
    //todo 贪心思路： 先考虑一边,右边比左边评分高就多得一颗糖(局部最优)
    // 然后再考虑另一边
    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len == 0) {
            return 0;
        }
        int[] candyDispatch = new int[len];
        for (int i = 0; i < len; i++) {
            candyDispatch[i] = 1;
        }
        //从左向右
        for (int i = 0; i < len - 1; i++) {
            //右边 > 左边
            if (ratings[i + 1] > ratings[i]) {
                candyDispatch[i + 1] = candyDispatch[i] + 1;
            }
        }
        //从右向左
        for (int i = len - 1; i > 0; i--) {
            //左边 > 右边
            if (ratings[i - 1] > ratings[i]) {
                // todo 本身可能更大
                candyDispatch[i - 1] = Math.max(candyDispatch[i] + 1, candyDispatch[i - 1]);
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += candyDispatch[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 2, 2};
        int res = new Solution().candy(ratings);
    }
}
