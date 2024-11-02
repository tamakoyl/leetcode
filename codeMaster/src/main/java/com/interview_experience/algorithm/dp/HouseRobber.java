package com.interview_experience.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[] dp = new int[n];
        boolean[] choose = new boolean[n];  // 用于记录是否选择偷第 i 个房屋

        dp[0] = nums[0];
        choose[0] = true;  // 第一个房屋被偷
        dp[1] = Math.max(nums[0], nums[1]);
        choose[1] = nums[1] > nums[0];  // 偷第 1 个房屋或第 2 个房屋

        for (int i = 2; i < n; i++) {
            if (dp[i-1] > nums[i] + dp[i-2]) {
                dp[i] = dp[i-1];
                choose[i] = false;
            } else {
                dp[i] = nums[i] + dp[i-2];
                choose[i] = true;
            }
        }

        // 回溯找到具体的偷窃房屋的序列
        List<Integer> stolenHouses = new ArrayList<>();
        int i = n - 1;
        while (i >= 0) {
            if (choose[i]) {
                stolenHouses.add(i);
                i -= 2;  // 跳过相邻的房屋
            } else {
                i -= 1;  // 继续查看前一个房屋
            }
        }

        System.out.println("Houses to steal: " + stolenHouses);
        return dp[n-1];
    }

    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();
        int[] nums = {3,2,5,10,7};
        int maxAmount = robber.rob(nums);
        System.out.println("Maximum amount that can be robbed: " + maxAmount);
    }
}
