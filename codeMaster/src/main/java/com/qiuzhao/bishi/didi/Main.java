package com.qiuzhao.bishi.didi;

/**
 * @Author:Tamako
 * @Date:2024/9/7 18:03
 * @Description:TODO
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取输入
        int n = sc.nextInt(); // 字符串长度
        int k = sc.nextInt(); // 字符集大小
        sc.nextLine(); // 读掉换行符
        String s = sc.nextLine(); // 输入的字符串
        int[][] cost = new int[k][k]; // 字符间的替换代价

        // 读取代价矩阵
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        // dp 数组，表示从 i 到 j 最小代价
        int[][] dp = new int[n][n];

        // 动态规划过程
        for (int len = 2; len <= n; len++) { // 区间长度
            for (int i = 0; i <= n - len; i++) { // 区间起点
                int j = i + len - 1; // 区间终点
                char ci = s.charAt(i), cj = s.charAt(j);
                dp[i][j] = Math.min(dp[i + 1][j] + cost[ci - 'a'][cj - 'a'], dp[i][j - 1] + cost[cj - 'a'][ci - 'a']);
                if (ci == cj) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - 1]);
                }
            }
        }

        // 输出结果
        System.out.println(dp[0][n - 1]);
    }
}

