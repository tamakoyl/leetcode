package com.tamako.backtracking.combinition.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/24 11:37
 * @Description:39. 组合总和
 */
public class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(target, candidates, 0, 0);
        return res;
    }


    private void backtracking(int target, int[] candidates, int startIndex, int sum) {
        //bounding 递归出口
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }

        //todo 如何实现可以重复取
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(target, candidates, i, sum);//可以重复取 所以startIndex不需要+1 todo 这里很关键！！
            sum -= path.get(path.size() - 1);
            path.remove(path.size() - 1);//回溯
        }
    }

    public List<List<Integer>> combinationSumOpt(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrackingOpt(target, candidates, 0,0);
        return res;
    }

    //剪枝
    // 是将原数组先进行排序
    private void backtrackingOpt(int target, int[] candidates, int startIndex,int sum) {
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
            backtrackingOpt(target, candidates, i,sum);//可以重复取 所以startIndex不需要+1
            sum -= path.get(path.size() - 1);
            path.remove(path.size() - 1);//回溯
        }
    }
}
