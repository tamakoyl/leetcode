package com.tamako.greedy.easy.lemonade_change;

/**
 * @Author:Tamako
 * @Date:2024/3/4 07:32
 * @Description:860.柠檬水找零
 */
public class Solution {

    // 贪心策略: 找钱优先找大的
    public boolean lemonadeChange(int[] bills) {
        int[] changeCnt = new int[2];
        for (int bill : bills) {
            if (bill == 5) {
                changeCnt[0]++;
            } else if (bill == 10) {
                if (changeCnt[0] <= 0) {
                    return false;
                }
                changeCnt[0]--;
                changeCnt[1]++;
            } else {
                if (changeCnt[0] <= 0 || changeCnt[1] == 0 && changeCnt[0] <= 2) {
                    return false;
                }
                if (changeCnt[1] == 0) {
                    changeCnt[0] -= 3;
                } else {
                    changeCnt[0]--;
                    changeCnt[1]--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int [] bills = {5,5,5,20};
        boolean res = new Solution().lemonadeChange(bills);
    }
}
