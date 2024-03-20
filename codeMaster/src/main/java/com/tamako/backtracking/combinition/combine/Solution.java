package com.tamako.backtracking.combinition.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/22 15:14
 * @Description:77. 组合
 */
public class Solution {
    private List<List<Integer>> results = new ArrayList<>();
    //todo
    private ArrayList<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return results;
    }

    void backtrackingOpt(int n, int k, int start) {
        //递归出口
        //bounding的条件是当路径的长度已经等于k的时候
        if (path.size() == k) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            //剪枝
            //当还需要的元素个数，已经大于可以使用的元素个数时 直接返回
            if(k - path.size() > n-i+1){
                return;
            }
            path.add(i);
            backtracking(n, k, i + 1);//递归
            path.remove(path.size()-1);//回溯，撤销节点处理
        }
    }

    //todo 剪枝优化
    void backtracking(int n, int k, int start) {
        //递归出口
        if (path.size() == k) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);//递归
            path.remove(path.size()-1);//回溯，撤销节点处理
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution().combine(4, 2);
    }
}
