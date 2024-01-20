package com.tamako.binary_tree.level.n_nodes_tree_level_traversal;

import com.tamako.utils.NNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:Tamako
 * @Date:2023/12/23 13:20
 * @Description:429. N 叉树的层序遍历
 */
public class Solution {
    public List<List<Integer>> levelOrder(NNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<NNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> oneLevelNodes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NNode front = queue.poll();
                oneLevelNodes.add(front.val);
                List<NNode> children = front.children;
                for (NNode child : children) {
                    if (child != null) queue.offer(child);
                }
            }
            res.add(oneLevelNodes);
        }
        return res;
    }
}
