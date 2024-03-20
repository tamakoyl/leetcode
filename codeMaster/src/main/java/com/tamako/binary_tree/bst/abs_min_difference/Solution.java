package com.tamako.binary_tree.bst.abs_min_difference;

import com.tamako.utils.TreeNode;

import java.util.Map;

/**
 * @Author:Tamako
 * @Date:2024/2/8 12:44
 * @Description:530. 二叉搜索树的最小绝对差
 */
public class Solution {
    //由于搜索树的特征：
    //中序遍历，两个相邻的节点之间：最小绝对值查
    private TreeNode pre = null;
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return min;
    }

    public void traversal(TreeNode root) {
        //递归出口
        if (root == null) {
            return;
        }
        //左
        traversal(root.left);
        //中
        if (pre != null) {
            min = Math.min(min, Math.abs(root.val - pre.val));
        }
        pre = root;
        //右
        traversal(root.right);

    }
}
