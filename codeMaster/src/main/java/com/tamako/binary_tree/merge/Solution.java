package com.tamako.binary_tree.merge;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/2/6 11:24
 * @Description:617. 合并二叉树
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //递归出口
        // todo 想得太复杂了,一个根为null 直接返回另一个根节点,不用再new一个node
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        //合并到t1
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.buildTreeByArray(new Integer[]{1, 3, 2, 5});
        TreeNode root2 = TreeNode.buildTreeByArray(new Integer[]{2, 1, 3, null, 4, null, 7});
        TreeNode root = new Solution().mergeTrees(root1, root2);
    }
}
