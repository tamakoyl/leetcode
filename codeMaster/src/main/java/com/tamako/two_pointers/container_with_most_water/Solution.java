package com.tamako.two_pointers.container_with_most_water;

/**
 * @Author:Tamako
 * @Date:2024/4/9 09:44
 * @Description:11. 盛最多水的容器
 */
public class Solution {
    //暴力枚举: 求矩形的最大面积
    public int maxAreaForceBrute(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return maxArea;
    }

    //双指针
    public int maxArea(int[] height) {
        int maxArea = 0, i = 0, j = height.length - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            //想要找更高的，面积才有可能变大
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

}
