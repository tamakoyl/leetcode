package com.tamako.May.sixteen;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author:Tamako
 * @Date:2023/4/16 00:40
 * @Description:1157. 子数组中占绝大多数的元素
 * dp 空间也会超过限制，暴力空间会超过限制
 * 官方给的是随机 + 二分查找
 */
public class MajorityChecker {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 1, 1};
        MajorityChecker majorityChecker = new MajorityChecker(arr);
        majorityChecker.query(2, 3, 2);
    }

    private HashMap<Integer, Integer> timesMap;
    private int dp[][][];

    private Integer[] repeatArray;

    public MajorityChecker(int[] arr) {
        ArrayList<Integer> repeatNums = new ArrayList<>();
        HashMap<Integer, Integer> timesMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (timesMap.get(arr[i]) == null) {
                timesMap.put(arr[i], 1);
                repeatNums.add(arr[i]);
            } else {
                int temp = timesMap.get(arr[i]) + 1;
                timesMap.put(arr[i], temp);
            }
        }
        Integer[] repeatArray = repeatNums.toArray(repeatNums.toArray(new Integer[timesMap.size()]));
        this.repeatArray = repeatArray;
        this.timesMap = timesMap;

        this.dp = new int[timesMap.size()][arr.length][arr.length];
        //初始化dp数组

        for (int i = 0; i < repeatArray.length; i++) {
            if (arr[0] == repeatArray[i]) {
                dp[i][0][0] = 1;
            }
        }


        for (int i = 0; i < dp.length; i++) {
            //初始化
            for (int k = 0; k < arr.length - 1; k++) {
                if (arr[k + 1] == repeatArray[i]) {
                    dp[i][0][k + 1] = dp[i][0][k] + 1;
                } else {
                    dp[i][0][k + 1] = dp[i][0][k];
                }
            }
            for (int j = 0; j < arr.length-1; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (arr[j] == repeatArray[i]) {
                        dp[i][j + 1][k] = dp[i][j][k] - 1;
                    } else {
                        dp[i][j + 1][k] = dp[i][j][k];
                    }
                }

            }
        }

    }

    public int query(int left, int right, int threshold) {
        for (int i = 0; i < dp.length; i++) {
            int times = dp[i][left][right];
            if(times >= threshold){
                return repeatArray[i];
            }
        }
        return -1;
    }
}
