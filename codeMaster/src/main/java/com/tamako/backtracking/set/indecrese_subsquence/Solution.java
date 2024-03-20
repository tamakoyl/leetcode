package com.tamako.backtracking.set.indecrese_subsquence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/28 15:22
 * @Description:491. 非递减子序列
 */
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        backtracking(0, nums);
        return res;
    }


    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    // todo 与之前的去重逻辑相区分开
    // todo 同一父节点下，同层需要去重

    private void backtracking(int startIndex, int[] nums) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));//收集子集
        }
        //递归出口
        //可以不用写 for 循环会有出口
        if (startIndex >= nums.length) {
            return;
        }
        //对本层元素去重
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (path.size() > 0 &&
                    nums[i] < path.get(path.size()-1) ||
                    hashSet.contains(nums[i])) {//todo 这里的条件也需要注意！！！
                continue;
            }
            path.add(nums[i]);
            hashSet.add(nums[i]);
            backtracking(i + 1, nums);//递归
            path.remove(path.size() - 1);//回溯
        }
    }
}
