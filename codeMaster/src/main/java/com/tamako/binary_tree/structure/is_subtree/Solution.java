package com.tamako.binary_tree.structure.is_subtree;

import com.tamako.utils.TreeNode;

import java.util.Stack;

/**
 * @Author:Tamako
 * @Date:2024/1/4 11:09
 * @Description:572. 另一棵树的子树
 */
public class Solution {
    //todo 思路！
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //需要比较root的每一个子树
        Stack<TreeNode> st = new Stack<>();
        if(root == null && subRoot ==null) return true;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode top =  st.pop();
            if(compare(top,subRoot))return true;
            if(top.left != null) st.push(top.left);
            if(top.right != null) st.push(top.right);
        }
        return false;
    }

    // 判断树的结构是否相同
    public boolean compare(TreeNode root1,TreeNode root2){
        //递归出口
        if(root1 == null && root2 == null) return true;
        if(root1 ==null || root2 == null || root1.val != root2.val) return false;
        boolean l = compare(root1.left,root2.left);
        boolean r = compare(root1.right,root2.right);
        return l && r;
    }
































}
