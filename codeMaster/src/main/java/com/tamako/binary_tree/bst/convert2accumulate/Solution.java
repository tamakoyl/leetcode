package com.tamako.binary_tree.bst.convert2accumulate;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/2/13 11:14
 * @Description:538. 把二叉搜索树转换为累加树
 */
public class Solution {
    private int sum = 0;

    // 累计顺序是 R N L
    public TreeNode convertBST(TreeNode root) {
        //递归出口
        if (root == null) {
            return null;
        }
        convertBST(root.right);//右
        sum += root.val;//中
        root.val = sum;
        convertBST(root.left);//左
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTreeByArray(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        TreeNode res = new Solution().convertBST(root);
    }
}
