package com.tamako.binary_tree.lowest_common_ancestor;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/2/10 11:16
 * @Description:236. 二叉树的最近公共祖先
 */
public class Solution {
    // 思路：后序遍历，遇到相同的节点，就是最近的公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归出口
        if (root == null || p == root || q == root) {
            return root;
        }
        //左
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //右
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //根
        //todo 在左子树中或者在右子树中找到p or q
        if (left != null && right != null) {
            return root;
        } else if (left == null) {// todo p or q是其父节点
            return right;
        } else {
            return left;
        }
    }
}
