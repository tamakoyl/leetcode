package com.tamako.binary_tree.bst.kth_smallest;

import com.tamako.utils.TreeNode;

import java.util.Stack;

/**
 * @Author:Tamako
 * @Date:2024/4/14 11:17
 * @Description:230. 二叉搜索树中第K小的元素
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k);
    }


    public int inorder(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode cur = root;
        while (!st.isEmpty() || cur != null) {
            //一直往左走
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                TreeNode top = st.pop();
                if (k == 1) {
                    return top.val;
                } else {
                    k--;
                }
                cur = top.right;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTreeByArray(new Integer[]{3, 1, 4, null, 2});
        new Solution().kthSmallest(root, 1);
    }
}
