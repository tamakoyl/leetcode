package com.tamako.binary_tree.level.print_every_level;

import com.tamako.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/8/19 16:46
 * @Description:层次遍历，分别输出每一层的次序
 */
public class LevelTraversal {
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTreeByArray(new Integer[]{1, 2, 3, 4});
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            ArrayList<Integer> levelRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.removeFirst();
                levelRes.add(cur.val);
                if (cur.left != null) {
                    que.offer(cur.left);
                }
                if (cur.right != null) {
                    que.offer(cur.right);
                }
            }
            res.add(levelRes);
        }
        System.out.println(res);
    }
}
