package com.qiuzhao.bishi.pdd;

/**
 * @Author:Tamako
 * @Date:2024/8/25 16:50
 * @Description:TODO
 */
import java.util.Scanner;

public class GiftExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 数组长度
        int x = scanner.nextInt();  // 初始的最大值
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int swapCount = 0;

        // 从右向左遍历数组
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] > x) {
                continue; // 当前元素已经大于 x，无需交换
            } else {
                // 当前元素小于 x，需要交换
                int temp = a[i];
                a[i] = x;
                x = temp;
                swapCount++;
            }

            // 检查如果已经是非递减序列则停止
            if (isSorted(a)) {
                System.out.println(swapCount);
                return;
            }
        }

        // 如果遍历结束仍然没有形成非递减序列
        System.out.println(-1);
    }

    // 检查整个数组是否为非递减序列
    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }
}

