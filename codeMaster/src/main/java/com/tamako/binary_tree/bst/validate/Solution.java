package com.tamako.binary_tree.bst.validate;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/2/6 11:55
 * @Description:98. 验证二叉搜索树
 */
public class Solution {
    //递归
    //思路:中序遍历是单调递增的
    //todo 使用全局变量 来记录当前的最大值或者前一个变量

    private TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        //递归出口
        if (root == null) {
            return true;
        }
        boolean l = isValidBST(root.left);
        // todo 需要严格递增
        if (pre != null && pre.left.val >= root.val) {
            return false;
        }
        pre = root;
        boolean r = isValidBST(root.right);
        return l && r;
    }

    public void inorderTraversal(TreeNode root) {
        //递归出口
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
    }


    // todo 迭代法也可以做的

    public static void main(String[] args) {
//        TreeNode root = TreeNode.buildTreeByArray(new Integer[]{5, 1, 4, null, null, 3, 6});
        TreeNode root = TreeNode.buildTreeByArray(new Integer[]{2, 1, 3});
        boolean res = new Solution().isValidBST(root);
        new Solution().inorderTraversal(root);
    }
}
