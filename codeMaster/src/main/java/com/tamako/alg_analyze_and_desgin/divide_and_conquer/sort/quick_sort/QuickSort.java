package com.tamako.alg_analyze_and_desgin.divide_and_conquer.sort.quick_sort;


/**
 * @Author:Tamako
 * @Date:2024/4/10 09:35
 * @Description:快速排序【比较归并排序】
 */
public class QuickSort {


    //i初始化成p也OK
    public int partition2(int[] nums, int p, int r) {
        int povit = nums[r];//主元
        //todo i的初始化
        int i = p, j = p;
        while (j < r) {
            if (nums[j] <= povit) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        //最后将主元插入正确的位置
        swap(nums, i, r);
        return i;//返回主元在的位置
    }

    //起始位置: p
    //终止位置: r
    public int partition(int[] nums, int p, int r) {
        int povit = nums[r];//主元
        //todo i的初始化
        int i = p - 1, j = p;
        while (j < r) {
            if (nums[j] <= povit) {
                swap(nums, i + 1, j);
                i++;
            }
            j++;
        }
        //最后将主元插入正确的位置
        swap(nums, i + 1, r);
        return i + 1;//返回主元在的位置
    }

    //todo swap要传入数组的引用呀
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void quickSort(int[] nums, int l, int r) {
        //递归出口
        if (l >= r) {
            return;
        }
        int pIndex = partition(nums, l, r);//得到主元的index
        quickSort(nums, l, pIndex - 1);//左分治
        quickSort(nums, pIndex, r);//右分治
    }

    public void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 4, 9};
        QuickSort quickSort = new QuickSort();
        System.out.print("排序前nums：");
        quickSort.printArray(nums);
        System.out.println("==================================");
        quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.print("排序后nums：");
        quickSort.printArray(nums);
    }
}
