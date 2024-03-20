package com.tamako.dp.basic.unique_path_1;

/**
 * @Author:Tamako
 * @Date:2024/3/7 11:00
 * @Description:62. 不同路径
 */
public class Solution {
    //1.dp[i,j]: 从(0,0)位置出发，到达(i,j)有dp[i,j]种路径
    //2. 初始化:dp[i,0]=1 dp[0,j]=1 todo 这个初始化: 从(0,0)到这些位置都只有一条路径
    //3. 递推: dp[i,j] = dp[i-1,j] + dp[i,j-1]【分别从右边、上边过来】
    //4. 遍历顺序: 从左往右，从上之下
    // 最后返回dp[m-1,n-1]
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
