package com.tamako.May.twenty_five;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author:Tamako
 * @Date:2023/4/27 09:38
 * @Description:2418. 按身高排序
 */
public class Solution {
    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        String[] res = new Solution().sortPeople(names, heights);

    }
     public String[] sortPeople(String[] names, int[] heights) {
         HashMap<Integer, Integer> heightMap = new HashMap<>();
         for (int i = 0; i < heights.length; i++) {
             heightMap.put(heights[i],i);
         }
         Arrays.sort(heights);
         String[] res = new String[names.length];
         for (int i = heights.length-1; i >=0; i--) {
             res[heights.length-i-1] = names[heightMap.get(heights[i])];
         }
         return res;
     }
}
