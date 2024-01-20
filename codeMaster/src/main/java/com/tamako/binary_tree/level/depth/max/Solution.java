package com.tamako.binary_tree.level.depth.max;

import com.tamako.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:Tamako
 * @Date:2023/12/29 10:51
 * @Description:104.二叉树的最大深度
 */
public class Solution {

    //层次遍历：迭代法
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> que = new LinkedList();
        if (root != null) que.offer(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode front = que.poll();
                if (front.left != null) que.offer(front.left);
                if (front.right != null) que.offer(front.right);
            }
            depth++;
        }
        return depth;
    }

    public int depth(TreeNode root){
        //递归出口
        //递归出口
        if(root == null) return 0;
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }
}
