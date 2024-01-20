package com.tamako.binary_tree.traversal.iterate;

import com.tamako.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author:Tamako
 * @Date:2023/12/22 10:53
 * @Description:二叉树遍历迭代方式
 */
public class Solution {
    private ArrayList<Integer> preorderList = new ArrayList<>();
    private ArrayList<Integer> postorderList = new ArrayList<>();
    private ArrayList<Integer> inorderList = new ArrayList<>();

    //todo 入栈 NRL 出 NLR
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        //todo 注意 判空
        if (root == null) return preorderList;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            preorderList.add(top.val);
            if (top.right != null) stack.push(top.right);
            if (top.left != null) stack.push(top.left);
        }
        return preorderList;
    }

    //todo 入NLR 出 NRL 翻转 LRN
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        //todo 注意 判空
        if (root == null) return postorderList;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            postorderList.add(top.val);
            if (top.left != null) stack.push(top.left);
            if (top.right != null) stack.push(top.right);
        }
        Collections.reverse(postorderList);
        return postorderList;
    }

    // todo 使用辅助指针
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return inorderList;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //一直往左走
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode top = stack.pop();
                inorderList.add(top.val);
                cur = top.right;
            }
        }
        return inorderList;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        new Solution().inorderTraversal(treeNode1);
    }

}
