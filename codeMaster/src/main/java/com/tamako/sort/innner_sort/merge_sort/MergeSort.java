package com.tamako.sort.innner_sort.merge_sort;

import java.util.Arrays;

/**
 * @Author:Tamako
 * @Date:2024/4/12 09:54
 * @Description:归并排序【比较快速排序】
 */
public class MergeSort {

    //合并过程
    public void merge(int[] nums, int l, int mid, int r) {
        //会用到辅助数组
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        int i = l, j = mid + 1, k = l;
        while (i <= mid && j <= r) {
            if (numsCopy[i] < numsCopy[j]) {
                nums[k++] = numsCopy[i++];
            } else {
                nums[k++] = numsCopy[j++];
            }
        }
        //复制剩下的元素
        while (i <= mid) {
            nums[k++] = numsCopy[i++];
        }
        while (j <= r) {
            nums[k++] = numsCopy[j++];
        }
    }


    public void mergeSort(int l, int r, int[] nums) {
        //递归出口
        if (l >= r) {
            return;
        }
        int mid = (r + l) / 2;
        mergeSort(l, mid, nums);//划分：递归左边
        mergeSort(mid + 1, r, nums);//划分：递归右边
        merge(nums, l, mid, r);//合并问题解
    }

    public void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 4, 9};
        MergeSort mergeSort = new MergeSort();
        System.out.print("排序前nums：");
        mergeSort.printArray(nums);
        System.out.println("==================================");
        System.out.print("排序后nums：");
        mergeSort.mergeSort(0, nums.length - 1, nums);
        mergeSort.printArray(nums);

    }
}
