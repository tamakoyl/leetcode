package com.tamako.binary_tree.bst.search;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/2/6 11:46
 * @Description:700. 二叉搜索树中的搜索
 */
public class Solution {

    //递归的方法
    public TreeNode searchBST(TreeNode root, int val) {
        //递归出口
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTreeByArray(new Integer[]{4, 2, 7, 1, 3});
    }
}
