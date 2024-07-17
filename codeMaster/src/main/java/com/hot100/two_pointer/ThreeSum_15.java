package com.hot100.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public static void main(String[] args) {
        threeSum(new int[] { 0, 0, 0, 0 });
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int begin = 0; begin <= nums.length - 3; begin++) {
            if (begin > 0 && nums[begin] == nums[begin - 1]) { // 第一个元素去重,跳过重复的元素
                continue;
            }
            int i = begin + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[begin] + nums[i] + nums[j];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[begin], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i + 1])
                        i++; // 第二个元素去重,跳过重复的元素
                    while (i < j && nums[j] == nums[j - 1])
                        j--; // 第三个元素去重，跳过重复的元素
                    // num[begin]固定，下一组考察数据
                    i++;
                    j--;
                } else if (sum < 0) {
                    i++;// 找更大的数
                } else {
                    j--;// 找更小的数
                }
            }
        }
        return res;
    }
}
