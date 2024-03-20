package com.tamako.binary_tree.bst.array_build;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/2/10 18:13
 * @Description:108. 将有序数组转换为二叉搜索树
 */
public class Solution {
    //todo:思路
    // 1.为什么需要是平衡二叉树呢？ 是为了防止线性构造二叉树
    // 2.回忆之前做过的构造二叉树的题，基本思路就是找分割点，递归构造左右子树
    // 3.本题目提供的是一个有序的数组，选取中间的元素作为分割点，也自然而然可以保持平衡树的特性
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return build(0, nums.length - 1, nums);
    }

    public TreeNode build(int l, int r, int[] nums) {
        //递归出口
        if (l > r) {
            return null;
        }
        //分割点
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = build(l, mid - 1, nums);
        TreeNode right = build(mid + 1, r, nums);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = new Solution().sortedArrayToBST(nums);
    }
}
