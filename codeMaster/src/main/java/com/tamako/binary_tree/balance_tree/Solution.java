package com.tamako.binary_tree.balance_tree;

import com.tamako.utils.TreeNode;

import java.util.Stack;

/**
 * @Author:Tamako
 * @Date:2024/1/4 14:10
 * @Description:110.平衡二叉树
 */
public class Solution {


    //todo 关键在于如何标识非平衡树 -> -1
    //递归时间复杂度O(n)
    public int getHeight(TreeNode root){
        //递归出口
        if(root == null) return 0;
        //左
        int l = getHeight(root.left);
        if(l == -1) return -1;
        //右
        int r = getHeight(root.right);
        if(r == -1) return -1;
        //判断是否平衡
        if(Math.abs(l - r) > 1)return -1;
        //返回高度
        return Math.max(l,r) + 1;
    }

    //迭代的方法：会重复计算height
    //时间复杂度：O(n^n)
    public boolean isBalanced(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if(root == null) return true;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode top = st.pop();
            int l = height(top.left);
            int r = height(top.right);
            if(Math.abs(l-r) > 1) return false;
            if(top.left!=null)st.push(top.left);
            if(top.right != null)st.push(top.right);
        }
        return true;
    }

    public int height(TreeNode root){
        //递归出口
        if(root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l,r) + 1;
    }
}
