package com.hot100.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class LongestConsecutive_128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        ArrayList<Integer> uniqueList = new ArrayList<>(set);
        if (uniqueList.size() <= 1)
            return uniqueList.size();
        Collections.sort(uniqueList);
        int cnt = 1;
        int res = 1;
        System.out.println(uniqueList);
        for (int i = 1; i < uniqueList.size(); i++) {
            if (uniqueList.get(i) - uniqueList.get(i - 1) == 1) {
                cnt++;
                res = Math.max(res, cnt);
            } else {
                cnt = 1;
                continue;
            }

        }

        return res;
    }

    public static int longestConsecutive2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res = 0;
        int cur = 0;
        int cnt = 1;
        for (Integer e : set) {
            cur = e;
            while (set.contains(++cur)) {
                cnt++;
            }
            res = Math.max(res, cnt);
            cnt = 1;
        }

        return res;
    }

}
