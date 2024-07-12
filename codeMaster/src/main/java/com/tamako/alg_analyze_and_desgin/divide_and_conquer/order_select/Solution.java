package com.tamako.alg_analyze_and_desgin.divide_and_conquer.order_select;

import java.util.Arrays;

/**
 * @Author:Tamako
 * @Date:2024/4/12 11:52
 * @Description:逆序对计数
 */
public class Solution {

    //在归并的过程就可以计数：逆序对
    public int reversePairs(int[] record) {
        int[] recordCopy = Arrays.copyOf(record, record.length);
        return cntInvert(0, record.length - 1, record, recordCopy);
    }

    //合并过程
    public int merge(int[] nums, int l, int mid, int r, int[] numsCopy) {
        //更新numsCopy
        for (int i = l; i <=r ; i++) {
            numsCopy[i] = nums[i];//因为nums已经变了
        }
        int cnt = 0;
        //会用到辅助数组
        int i = l, j = mid + 1, k = l;
        while (i <= mid && j <= r) {
            if (numsCopy[i] <= numsCopy[j]) {
                nums[k++] = numsCopy[i++];
            } else {
                nums[k++] = numsCopy[j++];
                cnt += mid - i + 1;//num[j] < 这个区间的数[i,mid]
            }
        }
        //复制剩下的元素
        while (i <= mid) {
            nums[k++] = numsCopy[i++];
        }
        while (j <= r) {
            nums[k++] = numsCopy[j++];
        }
        return cnt;
    }


    public int cntInvert(int l, int r, int[] nums, int[] numsCopy) {
        //递归出口
        if (l >= r) {
            return 0;
        }
        int mid = (r + l) / 2;
        int s1 = cntInvert(l, mid, nums, numsCopy);//划分：递归左边
        int s2 = cntInvert(mid + 1, r, nums, numsCopy);//划分：递归右边
        int s3 = merge(nums, l, mid, r, numsCopy);//合并问题解
        return s1 + s2 + s3;
    }


    public static void main(String[] args) {

    }
}
