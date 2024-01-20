package com.tamako.utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:Tamako
 * @Date:2023/12/22 10:25
 * @Description:二叉树定义
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTreeByArray(Integer[] treeNodeArray) {
        if (treeNodeArray == null || treeNodeArray.length == 0 || treeNodeArray[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(treeNodeArray[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < treeNodeArray.length; i += 2) {
            TreeNode current = queue.poll();

            if (treeNodeArray[i] != null) {
                current.left = new TreeNode(treeNodeArray[i]);
                queue.offer(current.left);
            }

            if (i + 1 < treeNodeArray.length && treeNodeArray[i + 1] != null) {
                current.right = new TreeNode(treeNodeArray[i + 1]);
                queue.offer(current.right);
            }
        }

        return root;
    }
}
