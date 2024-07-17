package com.hot100.two_pointer;

public class moveZeroes_283 {

    // 就是遍历一遍
    // i 指针遍历 把不为0的num
    // num[j] = num
    // 最后把j往后的num全变成0
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}
