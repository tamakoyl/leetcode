package com.qiuzhao.bishi.zhaoyinwangluo;

/**
 * @Author:Tamako
 * @Date:2024/9/2 19:20
 * @Description:TODO
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

public class ReverseWordsDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        // 去掉输入中的 '#'
        input = input.substring(0, input.length() - 1);

        // 分割输入的字符串
        String[] words = input.split(" ");
        int n = words.length;

        // 动态规划数组
        String[] dp = new String[n];

        // 初始化第一个单词
        dp[0] = words[0];

        // 填充动态规划表
        for (int i = 1; i < n; i++) {
            dp[i] = words[i] + " " + dp[i - 1];
        }

        // 最终逆序结果
        System.out.println(dp[n - 1]);
    }
}


