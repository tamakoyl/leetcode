package com.hot100.two_pointer;

public class TrappingRainWater_42 {

    public static void main(String[] args) {
        int res = trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
    }

    public static int trap(int[] height) {
        int i = 0, j = height.length - 1, leftMax = 0, rightMax = 0, total = 0;
        while (i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) {
                // 左边开始接水
                total += leftMax - height[i];
                i++;
            } else {
                // 右边开始接水
                total += rightMax - height[j];
                j--;
            }
        }
        return total;
    }

}
