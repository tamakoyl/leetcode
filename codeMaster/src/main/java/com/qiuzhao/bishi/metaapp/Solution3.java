package com.qiuzhao.bishi.metaapp;

import java.util.*;

/**
 * @Author:Tamako
 * @Date:2024/8/26 21:43
 * @Description:TODO
 */
public class Solution3 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // 读取输入整数
//        int n = scanner.nextInt();
//
//        // 如果 n 大于 100000，取 100000
//        if (n > 100000) {
//            n = 100000;
//        }
//
//        // 取绝对值
//        n = Math.abs(n);
//
//        // 将十进制数转换为七进制并存入数组
//        List<Integer> base7List = new ArrayList<>();
//
//        // 特殊情况处理: 如果 n 是 0，直接返回 [0]
//        if (n == 0) {
//            base7List.add(0);
//        } else {
//            while (n > 0) {
//                base7List.add(n % 7); // 取余数得到七进制的最低位
//                n /= 7; // 除以7得到剩余部分
//            }
//        }
//
//        // 因为余数是从低位到高位计算的，所以需要将数组反转
//        int[] base7Array = new int[base7List.size()];
//        for (int i = 0; i < base7List.size(); i++) {
//            base7Array[i] = base7List.get(base7List.size() - 1 - i);
//        }
//
//        // 输出数组结果
//        for (int i : base7Array) {
//            System.out.print(i + " ");
//        }
//
//        // 第二步：构建数组 B
//        int[] B = new int[base7Array.length];
//        int totalSum = 0;
//
//        // 计算 A 数组所有元素的总和
//        for (int value : base7Array) {
//            totalSum += value;
//        }
//
//        // 对于每个 B[i]，计算总和减去 A[i] 然后乘以 4
//        for (int i = 0; i < base7Array.length; i++) {
//            B[i] = (totalSum - base7Array[i]) * 4;
//        }
//
//        // 输出数组 B 的结果
//        for (int value : B) {
//            System.out.print(value + " ");
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取输入并转换为七进制数组 A
        int n = scanner.nextInt();
        if (n > 100000) {
            n = 100000;
        }
        n = Math.abs(n);
        // 七进制转换并存储在数组 A 中
        int[] A = convertToBase7(n);
        int[] B = computeBArray(A);
        // 第三步：对数组 B 进行排序并替换成排序后的序号
        int[] rankedArray = replaceWithRank(B);
        // 输出结果
        for (int value : rankedArray) {
            System.out.print(value + " ");
        }
    }

    // 第一步：十进制转七进制
    private static int[] convertToBase7(int n) {
        StringBuilder sb = new StringBuilder();

        if (n == 0) {
            sb.append(0);
        } else {
            while (n > 0) {
                sb.append(n % 7);
                n /= 7;
            }
        }

        int[] result = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            result[i] = sb.charAt(sb.length() - 1 - i) - '0';
        }

        return result;
    }

    // 第二步：计算数组 B
    private static int[] computeBArray(int[] A) {
        int totalSum = Arrays.stream(A).sum();
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = (totalSum - A[i]) * 4;
        }
        return B;
    }

    // 第三步：替换数组 B 中的元素为排序后的序号
    private static int[] replaceWithRank(int[] B) {
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);
        reverseArray(sortedB);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 10;
        for (int value : sortedB) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank++);
            }
        }

        int[] rankedArray = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            rankedArray[i] = rankMap.get(B[i]);
        }

        return rankedArray;
    }

    // 辅助方法：反转数组
    private static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

}
