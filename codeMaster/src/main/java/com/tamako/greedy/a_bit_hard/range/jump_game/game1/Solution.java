package com.tamako.greedy.a_bit_hard.range.jump_game.game1;

/**
 * @Author:Tamako
 * @Date:2024/3/1 10:52
 * @Description:55. 跳跃游戏
 */
public class Solution {
    // todo: 贪心的策略
    // j = len - 1
    // 局部最优： 可以从 j-- 到达 len-1 的位置
    //不断 向左移动 j
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goal) {//当前在的pos+移动的step是否能到goal
                goal = i;//更新goal，左移动
            }
        }
        return goal == 0;
    }


    //todo 贪心思路：可覆盖的区域可以到达 num.len-1的地方
    public boolean canJump2(int[] nums){
        if(nums.length == 0)return true;
       int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover,nums[i] + i);
            if(cover>=nums.length-1){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] num = {3,2,1,0,4};
        boolean res = new Solution().canJump2(num);
    }
}
