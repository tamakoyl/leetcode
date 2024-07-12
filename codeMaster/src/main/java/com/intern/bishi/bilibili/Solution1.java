package com.intern.bishi.bilibili;

import java.util.Scanner;

/**
 * @Author:Tamako
 * @Date:2024/4/28 19:42
 * @Description:环状 求subset
 */

public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //牛的数量
        int n = in.nextInt();
        if (n == 1) {
            System.out.println("1");
            return;
        }
        long res = n * (n - 1) + 1;
        System.out.println(res);
    }

}
