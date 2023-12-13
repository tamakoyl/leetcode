package com.tamako.May.fifteen;

import java.awt.font.GraphicAttribute;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2023/4/15 08:29
 * @Description:1042. 不邻接植花
 */
public class Solution {

    public static void main(String[] args) {
        int[][] paths = new int[][]{{1, 2}, {2, 3}, {3, 1}};
        int[][] paths2 = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}};
        int[][] paths3 = new int[][]{{3, 4}, {4, 2}, {3, 2}, {1, 3}};
        int[][] paths4 = new int[][]{{3, 4}, {4, 5}, {3, 2}, {5, 1}, {1, 3}};

        new Solution().gardenNoAdj(5, paths4);
    }

    //思路：1.找邻接矩阵，求连通分量 再使用回溯进行染色
    // 思路：2 直接暴力枚举
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] res = new int[n];
        boolean[] colorChoices;
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
        //构造邻接链表
        for (int i = 0; i < paths.length; i++) {
            adjList[paths[i][0] - 1].add(paths[i][1] - 1);
            adjList[paths[i][1] - 1].add(paths[i][0] - 1);
        }


        for (int i = 0; i < n; i++) {
            colorChoices = new boolean[4];
            //扫描相邻的节点,并查看其颜色
            for (Integer vertex : adjList[i]) {
                colorChoices[res[vertex]] = true;
            }
            //选择相邻节点没有选过的颜色
            for (int j = 1; j <= colorChoices.length; j++) {
                if(!colorChoices[j]){
                    res[i] = j;
                    break;
                }
            }

        }


        return res;
    }


}
