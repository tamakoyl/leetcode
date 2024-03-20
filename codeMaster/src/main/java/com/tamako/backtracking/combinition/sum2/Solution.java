package com.tamako.backtracking.combinition.sum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/24 14:30
 * @Description:40.组合总和II
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();


    //todo: 难点 candidates有重复的元素，但是res中不能有重复的组合
    // 排序后 for 横向遍历的时候不可以取重复的值
    //使用一个used数组来记录元素的使用情况
    //used[i] = true 代表 纵向遍历使用过

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtracking(target, candidates, 0, 0, used);
        return res;
    }


    private void backtracking(int target, int[] candidates, int startIndex, int sum, boolean[] used) {
        //bounding 递归出口
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            //保证横向遍历的时候不重复
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i-1]) {//todo 这个地方只能用i和i-1   //如果使用i和i+1的话 纵向遍历就不可以取重复的值
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            used[i] = true;
            backtracking(target, candidates, i + 1, sum, used);
            used[i] = false;
            sum -= path.get(path.size() - 1);
            path.remove(path.size() - 1);//回溯
        }
    }

    public List<List<Integer>> combinationSumOpt(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrackingOpt(target, candidates, 0, 0);
        return res;
    }

    //剪枝
    // 是将原数组先进行排序
    private void backtrackingOpt(int target, int[] candidates, int startIndex, int sum) {
        //bounding 递归出口
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            //剪枝
            if (sum + candidates[i] > target) {
                return;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backtrackingOpt(target, candidates, i, sum);//可以重复取 所以startIndex不需要+1
            sum -= path.get(path.size() - 1);
            path.remove(path.size() - 1);//回溯
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int target = 3;
        List<List<Integer>> res = new Solution().combinationSum2(nums, target);
    }
}
