package com.tamako.greedy.easy.dispatch_biscuits;

import java.util.Arrays;

/**
 * @Author:Tamako
 * @Date:2024/2/29 11:47
 * @Description:455. 分发饼干
 */
public class Solution {

    //贪心算法
    //局部最优  -> 全局最优
    public int findContentChildren(int[] g, int[] s) {
        int i = 0, j = 0, cnt = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                cnt++;
                i++;
            }
            j++;
        }
        return cnt;
    }
}
