package com.tamako.binary_tree.build.max;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/2/5 14:58
 * @Description:654.最大二叉树
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //递归出口
        if (nums.length == 0) {
            return null;
        }
        //切割点
        int maxIndex = findMaxIndex(nums);
        int rootVal = nums[maxIndex];
        TreeNode root = new TreeNode(rootVal);
        //切割左右子树
        //左边:[0,maxIndex)
        int[] left = new int[maxIndex];
        System.arraycopy(nums, 0, left, 0, maxIndex);
        //右边:(maxIndex,num.length-1]
        int[] right = new int[nums.length - maxIndex - 1];
        System.arraycopy(nums, maxIndex + 1, right, 0, nums.length - 1 - maxIndex);
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);
        return root;
    }

    public int findMaxIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                maxIndex = i;
                max = nums[i];
            }
        }
        return maxIndex;
    }
}
