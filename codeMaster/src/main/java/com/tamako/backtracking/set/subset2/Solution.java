package com.tamako.backtracking.set.subset2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/26 12:53
 * @Description:90.子集II
 */
public class Solution {
    //todo 这个题类似 sum2
    // 需要横向去重，纵向去重
    //需要去重
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(0, nums, used);
        return res;
    }


    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();


    // todo 使用used[]来去重
    private void backtracking(int startIndex, int[] nums, boolean[] used) {
        res.add(new ArrayList<>(path));//收集子集
        //递归出口
        //可以不用写 for 循环会有出口
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(i + 1, nums, used);//递归
            used[i] = false;
            path.remove(path.size() - 1);//回溯
        }
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(0, nums);
        return res;
    }
    //使用hashSet来将重
    //todo 还是需要排序呀！！！[1,4]和[4,1]是一样滴呀
    private void backtracking(int startIndex,int[] nums){
        res.add(new ArrayList<>(path));
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = startIndex; i <nums.length ; i++) {
            if(hashSet.contains(nums[i])){
                continue;
            }
            hashSet.add(nums[i]);
            path.add(nums[i]);
            backtracking(i+1,nums);
            path.remove(path.size()-1);
        }
    }


}
