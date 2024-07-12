package com.tamako.sort.innner_sort.heap_sort;

/**
 * @Author:Tamako
 * @Date:2024/4/9 10:43
 * @Description:堆排序
 *  应用：
 *  1.在10亿条数据中找出最大的100条的办法
 *
 * 在处理10亿条数据中找出最大的100条数据时，可以采用一种称为"Top K"问题的方法。
 * 以下是一种基于堆的解决方案：
 * (1)维护一个最小堆，堆的大小为100，最初堆为空。
 * (2)依次读取数据，将数据加入最小堆中。
 * (3)如果堆的大小超过了100，就将堆顶元素（当前堆中最小的元素）删除，保持堆的大小为100。
 * 最终，堆中剩下的100个元素就是最大的100条数据。
 * 这种方法的时间复杂度为O(nlogk)，其中n为数据总量，k为需要找出的最大数的数量。因为堆的大小为常数，插入和删除操作的时间复杂度是logk。
 *
 * 这种方法的优点是空间复杂度较低，只需要维护一个大小为k的堆，而不需要将所有数据存储在内存中。
 */
public class HeapSort {


    //调整成大顶堆或者小顶堆
    public void heapFyRecursive(int[] nums, int root, int heapSize) {
        int l = 2 * root + 1;
        int r = 2 * root + 2;
        int largest = root;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != root) {//调整过后，只能保证i与左右孩子是大根堆
            swap(nums, largest, root);
            heapFyRecursive(nums, largest,heapSize);//但是不保证，被swap下去的是否也是大顶堆，所以需要递归调整
        }
        //递归出口就是当当前largest == root
    }

    //从root开始从下调整
    public void heapFyIterate(int[] nums,int root,int heapSize){
        int l,r,largest;
        while (root  < heapSize){
             l = 2 * root + 1;
             r = 2 * root + 2;
             largest = root;
            if (l < heapSize && nums[l] > nums[largest]) {
                largest = l;
            }
            if (r < heapSize && nums[r] > nums[largest]) {
                largest = r;
            }
            if (largest != root) {//调整过后，只能保证i与左右孩子是大根堆
                swap(nums, largest, root);
                root = largest;
            }else {
                break;// todo 如果没有发生交换，说明已经满足堆的性质，可以退出循环
            }
        }
    }

    public void buildMaxHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
//            heapFyRecursive(nums, i,nums.length);
            heapFyIterate(nums, i,nums.length);
        }
    }


    public void heapSort(int[] nums) {
        buildMaxHeap(nums);//创建大顶堆
        for (int i = nums.length - 1; i > 0; i--) {
            //交换堆顶元素和末尾元素
            //0 堆顶元素
            //i 末尾元素
            swap(nums, 0, i);
//            heapFyRecursive(nums, 0,i);//将0～i的元素不断调整为大根堆
            heapFyIterate(nums, 0,i);//将0～i的元素不断调整为大根堆
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {12, 3, 17, 9, 7, 22, 8};
        HeapSort heapSort = new HeapSort();

        System.out.println("原始数组：");
        printArray(nums);

        heapSort.heapSort(nums);

        System.out.println("\n堆排序后的数组：");
        printArray(nums);
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


}
