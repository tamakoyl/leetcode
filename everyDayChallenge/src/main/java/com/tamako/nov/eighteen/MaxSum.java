package com.tamako.nov.eighteen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @Author:Tamako
 * @Date:2023/11/15 17:59
 * @Description:2342. 数位和相等数对的最大和
 */
class Solution18 {

    /**
     * 无脑hash
     * 每一个key->bitSum
     * val -> bitSum相同的数
     * 排序后取最大两个值
     * @param nums
     * @return
     */
    public int maximumSum(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> bitSumMap = new HashMap<>();
        for (int num : nums) {
            int bitSum = getBitSum(num);
            bitSumMap.computeIfAbsent(bitSum, k -> new ArrayList<>()).add(num);
        }
        int max = -1;
        for (ArrayList<Integer> numList : bitSumMap.values()) {
            if (numList.size() >= 2) {
                int maxTowNumsSum = getMaxTowNumsSum(numList);
                max = Math.max(maxTowNumsSum, max);
            }
        }
        return max;
    }


    /**
     * 三叶姐的思路
     * hash的值不用保存所有bitSum都相同的num
     * 只需要保存bitSum最大的num
     * @param nums
     * @return
     */
    public int maximumSum2(int[] nums) {
        HashMap<Integer, Integer> bitSumMaxSumMap = new HashMap<>();
        int maxSum = -1;
        for (int num : nums) {
            int bitSum = getBitSum(num);
            if(bitSumMaxSumMap.containsKey(bitSum)){
                maxSum = Math.max(maxSum, bitSumMaxSumMap.getOrDefault(bitSum, 0) + num);
            }
            bitSumMaxSumMap.put(bitSum, Math.max(num, bitSumMaxSumMap.getOrDefault(bitSum, 0)));
        }
        return maxSum;
    }


    public int getMaxTowNumsSum(ArrayList<Integer> numList) {
        numList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        return numList.get(0) + numList.get(1);
    }

    public int getBitSum(int num) {
        String numStr = String.valueOf(num);
        char[] numChars = numStr.toCharArray();
        int sum = 0;
        for (char numChar : numChars) {
            sum += Integer.parseInt(String.valueOf(numChar));
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {18, 43, 36, 13, 7};
        Solution18 solution18 = new Solution18();
        int res = solution18.maximumSum2(nums);
    }
}
