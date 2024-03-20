package com.tamako.binary_tree.bst.insert;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/2/10 12:43
 * @Description:701. 二叉搜索树中的插入操作
 */
public class Solution {

    //先不考虑重构二叉树的那种情况
    // 找到合适的空位插入即可

    /*递归的方式*/
    // todo 采用parent 来记录的方式
    private TreeNode parent = null;

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        traversal(root, val);
        return root;
    }

    public void traversal(TreeNode root, int val) {
        //递归出口
        if (root == null) {
            if (parent.val > val) {
                parent.left = new TreeNode(val);
            } else {
                parent.right = new TreeNode(val);
            }
            return;
        }
        parent = root;
        if (root.val > val) {
            traversal(root.left, val);
        } else {
            traversal(root.right, val);
        }
    }

    /*迭代的方式*/
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            if (cur.val > val && cur.left != null) {
                cur = cur.left;
            } else if (cur.val < val && cur.right != null) {
                cur = cur.right;
            } else if (cur.left == null && cur.val > val) {
                cur.left = new TreeNode(val);
                return root;
            } else {
                cur.right = new TreeNode(val);
                return root;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTreeByArray(new Integer[]{4, 2, 7, 1, 3});
        TreeNode res = new Solution().insertIntoBST(root, 5);
        TreeNode res2 = new Solution().insertIntoBST2(root, 5);
    }
}
