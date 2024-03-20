package com.tamako.hash.sum_four_nums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/20 13:23
 * @Description:第18题. 四数之和
 */
public class Solution {
    // a+b+c+d
    // todo 需要考虑去重
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if (nums[i] > target && nums[i] >= 0) {
                break;
            }
            //a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                //剪枝
                if (nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) {
                    break;
                }
                //b去重
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1, r = nums.length - 1;//todo  lr取值在(j,num.length),就不用担心j和r或l重合的问题
                while (l < r) {
                    long n = nums[i] + nums[j] + nums[l] + nums[r];
                    if (n > target) {
                        l++;
                    } else if (n < target) {
                        r--;
                    } else {
                        ArrayList<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[l]);
                        res.add(nums[r]);
                        results.add(res);
                        //对l、r去重逻辑应该放在找到第一个四元组
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
        }
        return results;
    }
}
