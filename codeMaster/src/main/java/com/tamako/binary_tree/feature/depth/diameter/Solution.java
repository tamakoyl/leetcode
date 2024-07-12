package com.tamako.binary_tree.feature.depth.diameter;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/4/14 10:57
 * @Description:543. 二叉树的直径
 */
public class Solution {
    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);
        return res;
    }

    public int getMaxDepth(TreeNode root) {
        // 递归出口
        if (root == null) {
            return 0;
        }
        int lDepth = getMaxDepth(root.left);
        int rDepth = getMaxDepth(root.right);
        res = Math.max(res, lDepth + rDepth);
        return Math.max(lDepth, rDepth) + 1;
    }
}
