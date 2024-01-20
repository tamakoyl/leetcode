package com.tamako.binary_tree.structure.is_same;

import com.tamako.utils.TreeNode;

import java.util.Stack;

/**
 * @Author:Tamako
 * @Date:2024/1/4 10:52
 * @Description:100. 相同的树
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // return iterateWay(p,q);
        return compare(p,q);
    }

    public boolean compare(TreeNode left , TreeNode right){
        //递归出口
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;

        //左边
        boolean l = compare(left.left,right.left);
        boolean r = compare(left.right,right.right);
        return l && r;
    }

    public boolean iterateWay(TreeNode p, TreeNode q){
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        if(q == null && p !=null || p == null && q!=null)return false;
        st1.push(p);
        st2.push(q);
        while(!st1.isEmpty() && !st2.isEmpty()){
            TreeNode top1 = st1.pop();
            TreeNode top2 = st2.pop();
            if(top1 == null && top2 ==null)continue;
            if(top1 == null || top2 == null || top1.val != top2.val) return false;
            st1.push(top1.left);
            st1.push(top1.right);
            st2.push(top2.left);
            st2.push(top2.right);
        }
        return true;
    }
}
