package com.tamako.binary_tree.level.right_side_view;

import com.tamako.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:Tamako
 * @Date:2023/12/23 12:55
 * @Description: 199. 二叉树的右视图
 */
public class Solution {
    //每层最右边的结点
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode front = queue.poll();
                if (i == size - 1) {
                    res.add(front.val);
                }
                if (front.left != null) queue.offer(front.left);
                if (front.right != null) queue.offer(front.right);
            }
        }
        return res;
    }
}
