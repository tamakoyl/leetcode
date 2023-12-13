package com.tamako.december.two;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:Tamako
 * @Date:2023/12/2 11:00
 * @Description: 1094. Car Pooling
 */
public class Solution2 {

    //面向测试用例编程了
//    public boolean carPooling(int[][] trips, int capacity) {
//        //按照trip的开始Loc进行排序
//        Arrays.sort(trips, Comparator.comparingInt(trip -> trip[1]));
//        int cnt = trips[0][0];
//        int startLoc = 0;
//        for (int i = 1; i < trips.length; i++) {
//            //和上一躺trip没有交集
//            if (trips[i][1] >= trips[i - 1][2]) {
//                cnt = trips[i][0];
//                startLoc = i;
//            } else {
//                //和上一趟trip有交集
//                cnt += trips[i][0];
//                int j = i - 1;
//                int loc = startLoc;
//                //前面结束的旅程释放座位
//                while (--j >= loc) {
//                    if (trips[i][1] >= trips[j][2]) {
//                        cnt -= trips[j][0];
//                        startLoc = j + 1;//释放过后也需要更新
//                    }
//                }
//            }
//            if (cnt > capacity) {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean carPooling(int[][] trips, int capacity) {
        //原数组代表：在i位置车上的人数
        //差分数组
        int[] differentNum = new int[1010];
        for (int i = 0; i < trips.length; i++) {
            int addPeople = trips[i][0];
            int startLoc = trips[i][1];
            int endLoc = trips[i][2];
            //对原数组[startLoc,endLoc]+addPeople
            //相当于对差分数组的startLoc的元素+addPeople,对endLoc的元素-addPeople
            //数组下标
            differentNum[startLoc + 1] += addPeople;
            differentNum[endLoc + 1] -= addPeople;
        }

        for (int i = 1; i <= 1000; i++) {
            //对差分数组进行前缀和计算，得到原数组
            differentNum[i] += differentNum[i - 1];
            if (differentNum[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {
                {4, 5, 6},
                {6, 4, 7},
                {4, 3, 5},
                {2, 3, 5}
        };
        boolean res = new Solution2().carPooling(trips, 13);
    }
}
