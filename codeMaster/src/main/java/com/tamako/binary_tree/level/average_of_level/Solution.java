package com.tamako.binary_tree.level.average_of_level;

import com.tamako.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:Tamako
 * @Date:2023/12/23 13:05
 * @Description: 637. 二叉树的层平均值
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode front = queue.poll();
                sum += front.val;
                if (front.left != null) queue.offer(front.left);
                if (front.right != null) queue.offer(front.right);
            }
            res.add(sum/size);
        }
        return res;
    }
}
