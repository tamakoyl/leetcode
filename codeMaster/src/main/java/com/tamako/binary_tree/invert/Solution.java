package com.tamako.binary_tree.invert;

import com.tamako.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author:Tamako
 * @Date:2023/12/29 14:30
 * @Description:226. 翻转二叉树
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        invertPostTraversal(root);
        return root;
    }


    public void invertLevelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) que.offer(root);
        while (!que.isEmpty()) {
            TreeNode front = que.poll();
            TreeNode temp = front.left;
            front.left = front.right;
            front.right = temp;
            if (front.left != null) que.offer(front.left);
            if (front.right != null) que.offer(front.right);
        }
    }

    //迭代的方法
    // todo 前序和后序 翻转一次
    // 中序遍历 会翻转两次 所以🙅 中序遍历的迭代 还不会写！！！！！
    public void invertInOrderIterate(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while (!st.isEmpty() || cur != null) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                //两次回到N，所以会翻转两次
                TreeNode top = st.pop();
                TreeNode temp = top.left;
                top.left = top.right;
                top.right = temp;
                cur = top.right;
            }
        }
    }


    public void invertPostOrderIterate(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.isEmpty()) {
            TreeNode top = st.pop();
            TreeNode temp = top.left;
            top.left = top.right;
            top.right = temp;
            if (top.right != null) st.push(top.right);
            if (top.left != null) st.push(top.left);
        }
    }

    public void invertPreOrderIterate(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.isEmpty()) {
            TreeNode top = st.pop();
            TreeNode temp = top.left;
            top.left = top.right;
            top.right = temp;
            if (top.left != null) st.push(top.left);
            if (top.right != null) st.push(top.right);
        }
    }


    // 递归的后序遍历
    public void invertPostTraversal(TreeNode root) {
        //递归出口
        if (root == null) {
            return;
        }
        invertPostTraversal(root.left);
        invertPostTraversal(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    //递归的前序遍历
    public void invertPreOrderTraversal(TreeNode root) {
        //递归出口
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertPostTraversal(root.left);
        invertPostTraversal(root.right);
    }


    //遍历的中序遍历[严格来说不是中序遍历]
    public void invertInOrderTraversal(TreeNode root) {
        //递归出口
        if (root == null) {
            return;
        }
        invertPostTraversal(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //已经交换过了
        invertPostTraversal(root.left);
    }

}
