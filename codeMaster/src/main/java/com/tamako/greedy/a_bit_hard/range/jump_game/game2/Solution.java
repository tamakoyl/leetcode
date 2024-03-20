package com.tamako.greedy.a_bit_hard.range.jump_game.game2;

/**
 * @Author:Tamako
 * @Date:2024/3/1 12:45
 * @Description:45.跳跃游戏 II
 */
public class Solution {

    //todo 贪心策略：
    // 思路清晰一下！！！
    //观察当前覆盖的范围，和下一个覆盖范围可以覆盖的范围，选其中覆盖最广的
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;//todo 直接到达goal
        int step = 0;
        int curDistance = 0;//当前覆盖范围最远的位置
        int nextDistance = 0;//下一步覆盖范围
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nextDistance, i + nums[i]);
            if (curDistance == i) {
                step++;
                curDistance = nextDistance;
            }
            if (curDistance >= nums.length - 1) {//当前距离到达goal了
                break;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 1, 1, 4};
        int res = new Solution().jump(num);
    }
}
