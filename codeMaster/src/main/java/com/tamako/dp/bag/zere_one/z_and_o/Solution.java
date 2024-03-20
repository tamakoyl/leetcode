package com.tamako.dp.bag.zere_one.z_and_o;

/**
 * @Author:Tamako
 * @Date:2024/3/10 11:04
 * @Description:474. 一和零
 */
public class Solution {

    //两个维度的背包
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {//遍历物品
            int[] w = cntZeroAndOne(strs[i]);
            for (int j = m; j >= w[0]; j--) {//todo 遍历背包，用两层for循环呀！！！
                for (int k = n; k >= w[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - w[0]][k - w[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] cntZeroAndOne(String str) {
        int cntZero = 0;
        int cntOne = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') cntOne++;
            if (str.charAt(i) == '0') cntZero++;
        }
        return new int[]{cntZero, cntOne};
    }

    public static void main(String[] args) {
        String[] strings =
                {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        int res = new Solution().findMaxForm(strings, m, n);
    }
}
