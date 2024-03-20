package com.tamako.hash.happy_num;

import java.util.HashSet;

/**
 * @Author:Tamako
 * @Date:2024/2/16 11:57
 * @Description:第202题. 快乐数
 */
public class Solution {
    // todo: 思路就是会有无限循环的情况，所以需要用hash记录，重复出现就代表不是快乐数了
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            if (n < 10) {
                sum += n * n;
            } else {
                while (n > 0) {
                    int tmp = n % 10;
                    sum += tmp * tmp;
                    n /=10;
                }
            }
            n = sum;
            if (hashSet.contains(n)) {
                return false;
            }
            hashSet.add(sum);
        }
        return true;
    }


    public static void main(String[] args) {
        boolean res = new Solution().isHappy(2);

    }
}
