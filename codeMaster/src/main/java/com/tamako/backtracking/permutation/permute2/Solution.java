package com.tamako.backtracking.permutation.permute2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/28 18:04
 * @Description:47.全排列 II
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return res;
    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();


    private void backtracking(int[] nums, boolean[] used) {
        //递归出口
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //同层去重
            //todo 回溯过后，used[i] == false 同层使用过
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            //todo 未被使用才才加入path
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }

        }
    }
}
