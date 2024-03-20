package com.tamako.hash.sum_three_nums;

import java.util.*;

/**
 * @Author:Tamako
 * @Date:2024/2/20 13:23
 * @Description:第15题. 三数之和
 */
public class Solution {
    //将其转化为两数求和  使用hash -> 需要考虑到去重 然后还保了一个错误
    //todo 双指针法！！ 没想到！

    //todo 难点：去重！！！三元组 a b c 都需要考虑去重
    public List<List<Integer>> threeSum2(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            //第一个数>0就没必要再比较下去
            if (nums[i] > 0) {
                return results;
            }
            //对a去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int n = nums[i] + nums[l] + nums[r];
                if (n > 0) {
                    --r;
                } else if (n < 0) {
                    ++l;
                } else {
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[l]);
                    res.add(nums[r]);
                    results.add(res);
                    //对b、c去重逻辑应该放在找到第一个三元组
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    //下一个位置
                    l++;
                    r--;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution().threeSum2(new int[]{0,0,0,0});
    }
}
