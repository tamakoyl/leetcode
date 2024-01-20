package com.tamako.binary_tree.level.depth.min;

import com.tamako.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:Tamako
 * @Date:2023/12/29 12:09
 * @Description:111. 二叉树的最小深度
 */
public class Solution {

    //层次遍历：迭代
    public int minDepth(TreeNode root) {
        Queue<TreeNode> que = new LinkedList();
        if (root != null) que.offer(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode front = que.poll();
                if (front.left == null && front.right == null) return depth + 1;
                if (front.left != null) que.offer(front.left);
                if (front.right != null) que.offer(front.right);
            }
            depth++;
        }
        return depth;
    }


    public int minD(TreeNode root) {
        //todo 多种递归出口
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int rightDepth = Integer.MAX_VALUE;
        int leftDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            leftDepth = minD(root.left) + 1;
        }
        if (root.right != null) {
            rightDepth = minD(root.right) + 1;
        }
        return Math.min(rightDepth, leftDepth);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(2);
//        TreeNode node1 = new TreeNode(2);
//        root.right = node1;
//        TreeNode node2 = new TreeNode(3);
//        node2.right = node1;
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(5);
//        node3.right = node4;
//        TreeNode node5 = new TreeNode(6);
//        node4.right = node5;
        // todo 由数组构建二叉树
        TreeNode root = TreeNode.buildTreeByArray(new Integer[]{2, null, 3, null, 4, null, 5, null, 6});
        int res = new Solution().minD(root);

    }
}
