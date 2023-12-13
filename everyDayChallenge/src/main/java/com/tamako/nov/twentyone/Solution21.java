package com.tamako.nov.twentyone;

/**
 * @Author:Tamako
 * @Date:2023/11/21 09:46
 * @Description:2216. 美化数组的最少删除数
 * 三叶姐的题解
 */
public class Solution21 {
    public int minDeletion(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        for (int i = 0; i < len - 1; i++) {
            //  移除一个元素后，当前元素的下标为i-cnt
            if ((i - cnt) % 2 == 0 && nums[i] == nums[i + 1]) {
                cnt++;
            }
        }
        //因为美化数组的长度为偶数，最后得到的长度为奇数的话还需要移除最后一个元素
        return (len - cnt) % 2 == 0 ? cnt : cnt + 1;
    }
}
