package com.tamako.greedy.mid.two_dimension.que_reconstruct_height;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author:Tamako
 * @Date:2024/3/4 07:58
 * @Description:406. 根据身高重建队列
 */
public class Solution {
    //todo 贪心策略：
    // 首先是两个维度: 身高和k(当前位置前面比自己高的)
    // 应该先确定身高维度: 可以确定当前节点前面的都更高(降序)

    // todo 需要学习的
    // 1. 二维数组，依据某一个维度进行排序
    // 2. LinkedList按index构建
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (b[0] == a[0]) return a[1] - b[1];//身高相同，按照k值升序来
            return b[0] - a[0];//降序
        });
        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            //k就是指定的位置
            que.add(p[1],p);   //Linkedlist.add(index, value)，會將value插入到指定index裡。
        }
        return que.toArray(new int[people.length][]);
    }
}
