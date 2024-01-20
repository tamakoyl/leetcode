package com.tamako.december.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author:Tamako
 * @Date:2023/12/1 09:53
 * @Description: 2661. 找出叠涂元素
 */
public class Solution1 {


    //模拟法
    public int firstCompleteIndex2(int[] arr, int[][] mat) {
        int m = mat.length;//行数
        int n = mat[0].length;//列数
        //每一行被涂色的个数
        int[] rowPaintedCnt = new int[m];
        //每一列被涂色的个数
        int[] colPaintedCnt = new int[n];

        //记录元素在mat中的位置
        HashMap<Integer, int[]> posMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                posMap.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] pos = posMap.get(arr[i]);
            if (++rowPaintedCnt[pos[0]] == n || ++colPaintedCnt[pos[1]] == m) {
                return i;
            }
        }
        return -1;//never
    }


    private HashSet<Integer> curSet = new HashSet<>();

    //暴力：判断mat矩阵的一行或者一列是否是arr的子集即可
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < arr.length; i++) {
            curSet.add(arr[i]);
            boolean b = checkRowAndColumn(mat, arr, i + 1);
            if (b) {
                return i;
            }
        }
        return -1;
    }


    boolean checkRowAndColumn(int[][] mat, int[] arr, int size) {
        int m = mat.length;
        int n = mat[0].length;
        if (size < Math.min(m, n)) {
            return false;
        }
        //检查行元素
        for (int i = 0; i < m; i++) {
            boolean b = isSubset(mat[i], arr, size);
            if (b) return true;
        }
        //检查列元素
        for (int i = 0; i < n; i++) {
            int[] column = new int[m];
            for (int j = 0; j < m; j++) {
                column[j] = mat[j][i];
            }
            boolean b = isSubset(column, arr, size);
            if (b) return true;
        }
        return false;
    }

    boolean isSubset(int[] smallSet, int[] bigSet, int bigSetSize) {
        for (int i : smallSet) {
            boolean b = find(bigSet, i, bigSetSize);
            //没有找到该元素
            if (!b) return false;
        }
        return true;
    }

    boolean find(int[] arr, int target, int size) {
        if (curSet.contains(target)) {
            return true;
        }
        for (int i = 0; i < size; i++) {
            if (arr[i] == target) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {2, 8, 7, 4, 1, 3, 5, 6, 9};
        int[][] mat = {{3, 2, 5}, {1, 4, 6}, {8, 7, 9}};
        int res = new Solution1().firstCompleteIndex2(arr, mat);
    }
}
