package com.tamako.binary_tree.level.find_level_max;

import com.tamako.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:Tamako
 * @Date:2023/12/29 09:07
 * @Description:515.在每个树行中找最大值
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode first = queue.poll();
                max = Math.max(first.val, max);
                if (first.left != null) queue.offer(first.left);
                if (first.right != null) queue.offer(first.right);
            }
            res.add(max);
        }
        return res;
    }
}
