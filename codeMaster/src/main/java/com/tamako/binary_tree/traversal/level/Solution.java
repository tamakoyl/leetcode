package com.tamako.binary_tree.traversal.level;

import com.tamako.utils.TreeNode;

import java.util.*;

/**
 * @Author:Tamako
 * @Date:2023/12/23 11:50
 * @Description:102. 二叉树的层序遍历
 */
public class Solution {

    //todo 递归


    //自顶向下
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> oneLevelNodes = new ArrayList<>();
            int size = queue.size();
            // todo 使用队列，先遍历完这一层
            for (int i = 0; i < size; i++) {
                TreeNode front = queue.poll();
                oneLevelNodes.add(front.val);
                if (front.left != null) queue.offer(front.left);
                if (front.right != null) queue.offer(front.right);
            }
            res.add(oneLevelNodes);
        }
        return res;
    }

    //自底向上
    //翻转层次遍历的结果即可
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> oneLevelNodes = new ArrayList<>();
            int size = queue.size();
            // todo 使用队列，先遍历完这一层
            for (int i = 0; i < size; i++) {
                TreeNode front = queue.poll();
                oneLevelNodes.add(front.val);
                if (front.left != null) queue.offer(front.left);
                if (front.right != null) queue.offer(front.right);
            }
            res.add(oneLevelNodes);
        }
        Collections.reverse(res);
        return res;
    }
}
