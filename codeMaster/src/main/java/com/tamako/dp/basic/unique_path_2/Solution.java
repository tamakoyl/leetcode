package com.tamako.dp.basic.unique_path_2;

/**
 * @Author:Tamako
 * @Date:2024/3/7 11:00
 * @Description:63. 不同路径 II
 */
public class Solution {
    //路障版
    //1.dp[i,j]: 从(0,0)位置出发，到达(i,j)有dp[i,j]种路径
    //2. 初始化:
    // 有障碍的地方dp[i,j]=-1
    // todo 如果有路障后面的格子都是0，dp[i,0]=0， 这个初始化: 从(0,0)到这些位置都只有一条路径
    //3. 递推: dp[i,j] = dp[i-1,j] + dp[i,j-1]【分别从右边、上边过来】
    //4. 遍历顺序: 从左往右，从上之下
    // 最后返回dp[m-1,n-1]
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        boolean rowFlag = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                rowFlag = true;
            }
            if (!rowFlag) {
                dp[i][0] = 1;
            }
        }

        boolean colFlag = false;
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                colFlag = true;
            }
            if (!colFlag) {
                dp[0][j] = 1;
            }
        }
        //初始化
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
