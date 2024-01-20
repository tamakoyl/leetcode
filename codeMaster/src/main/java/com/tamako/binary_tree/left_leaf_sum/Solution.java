package com.tamako.binary_tree.left_leaf_sum;

import com.tamako.utils.TreeNode;

import java.util.Stack;

/**
 * @Author:Tamako
 * @Date:2024/1/17 16:52
 * @Description:404.左叶子之和
 */
public class Solution {

    private int cnt = 0;
    //递归法
    public int sumOfLeftLeaves(TreeNode root) {
        sum(root);
        return cnt;
    }
    public void sum(TreeNode root) {
        //递归出口
        if(root == null)return;
        if(root.left == null && root.right == null) return;//其实这个也可以不写，如果不写不影响结果，但就会让递归多进行了一层
        if(root.left!=null && root.left.left == null && root.left.right == null) {
            cnt+=root.left.val;
        }
        //左子树+右子树的左叶子和
        sum(root.left);
        sum(root.right);
    }

    //迭代法
    public int iterateWay(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        int cnt = 0;
        if(root == null)return 0;
        st.push(root);
        while(!st.isEmpty()){
           TreeNode top =  st.pop();
           if(top.left!=null&&top.left.left==null&&top.left.right == null)cnt+=top.left.val;
           if(top.left!=null)st.push(top.left);
           if(top.right!=null)st.push(top.right);
        }
        return cnt;
    }

}
