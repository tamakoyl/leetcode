package com.tamako.backtracking.permutation.permute1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/28 17:49
 * @Description:46.全排列
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtracking(nums,used);
        return res;
    }


    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    //todo 不需要startIndex [1,2] 和 [2,1] 是两个集合都会用到
    private void backtracking(int[] nums, boolean[] used) {
        //递归出口
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {//已经收集了该元素，直接跳过
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
