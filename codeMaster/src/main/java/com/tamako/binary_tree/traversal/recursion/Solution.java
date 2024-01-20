package com.tamako.binary_tree.traversal.recursion;

import com.tamako.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2023/12/22 10:27
 * @Description:二叉树的前中后遍历
 */
public class Solution {
    private ArrayList<Integer> preorderList = new ArrayList<>();
    private ArrayList<Integer> postorderList = new ArrayList<>();
    private ArrayList<Integer> inorderList = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return preorderList;
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        preorderList.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(TreeNode root) {
        //递归出口
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        postorderList.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return postorderList;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return inorderList;
    }

    public void inorder(TreeNode root){
        //递归出口
        if(root == null){
            return ;
        }
        inorder(root.left);
        inorderList.add(root.val);
        inorder(root.right);
    }
}
