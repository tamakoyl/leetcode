package com.tamako.backtracking.set.subset;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/26 12:25
 * @Description:78. 子集
 */
public class Solution {
    //todo 子集就是需要遍历完整棵状态空间树，所以不需要剪枝
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(0, nums);
        return res;
    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    private void backtracking(int startIndex, int[] nums) {
        res.add(new ArrayList<>(path));//收集子集
        //递归出口
        //可以不用写 for 循环会有出口
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(i + 1, nums);//递归
            path.remove(path.size() - 1);//回溯
        }
    }

    public static void main(String[] args) {
        int[] nums ={1,2,3};
        List<List<Integer>> res = new Solution().subsets(nums);
    }
}
