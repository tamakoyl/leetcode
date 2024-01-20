package com.tamako.binary_tree.structure.is_symmetric;

import com.tamako.utils.TreeNode;

import java.util.Stack;

/**
 * @Author:Tamako
 * @Date:2024/1/1 13:52
 * @Description:101. 对称二叉树
 */
public class Solution {

    //todo 槛槛都没有摸到
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left,root.right);
    }
    public boolean compare(TreeNode left,TreeNode right){
        //递归出口
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val!= right.val)return false;
        //比较外侧
        boolean outside = compare(left.left, right.right);
        //比较内侧
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }


    //迭代法： 使用两个栈 来比较左右子树是否对称
    public boolean iterateWay(TreeNode root){
        Stack<TreeNode> stLeft = new Stack<>();
        Stack<TreeNode> stRight = new Stack<>();
        if(root == null)return true;
        stLeft.push(root);
        stRight.push(root);
        while(!stLeft.isEmpty() && !stRight.isEmpty()){
            TreeNode topL = stLeft.pop();
            TreeNode topR = stRight.pop();
            if(topL == null && topR == null) continue;
            // if(topL == null && topR!=null||
            // topL!=null && topR==null)return false;
            // if(topL!=null && topR!=null&&
            // topL.val!=topR.val) return false;
            //todo 合并的写法 很简洁呀！！
            if(topL == null || topR == null || topL.val != topR.val) return false;
            stLeft.push(topL.left);
            stLeft.push(topL.right);
            stRight.push(topR.right);
            stRight.push(topR.left);
        }
        return true;
    }


}
