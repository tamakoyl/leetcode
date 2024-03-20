package com.tamako.backtracking.combinition.sum3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/23 16:27
 * @Description:216.组合总和III
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, 1, n, 0);
        return res;
    }


    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private void backtracking(int k, int startIndex, int n, int sum) {
        //递归出口
        //bounding func
        if (path.size() == k && sum == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            sum += i;
            path.add(i);
            backtracking(k, i + 1, n, sum);//递归求解
            sum -= path.get(path.size() - 1);//回溯
            path.remove(path.size() - 1);
        }
    }

    //剪枝
    private void backtrackingOpt(int k, int startIndex, int n, int sum) {
        //递归出口
        //bounding func
        if (path.size() == k && sum == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            //剪枝
            if(sum + i > n){
                return;
            }
            sum += i;
            path.add(i);
            backtracking(k, i + 1, n, sum);//递归求解
            sum -= path.get(path.size() - 1);//回溯
            path.remove(path.size() - 1);
        }
    }
}
