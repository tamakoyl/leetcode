package com.tamako.binary_tree.bst.find_mode;

import com.tamako.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:Tamako
 * @Date:2024/2/8 16:07
 * @Description:501. 二叉搜索树中的众数
 */
public class Solution {
    // todo 一次遍历是否可以直接得到结果？思想需要学习一下
    private List<Integer> res = new ArrayList<>();
    private int maxCnt = 0;
    private int curCnt = 1;
    private TreeNode pre = null;

    private void traversal2(TreeNode root) {
        //递归出口
        if (root == null) {
            return;
        }
        traversal2(root.left);
        //计数
        if (pre != null && pre.val == root.val) {
            curCnt++;
        }
        //归零
        if (pre != null && pre.val != root.val) {
            curCnt = 1;
        }
        //遇到更大的频数，清空结果集
        if (curCnt > maxCnt) {
            res = new ArrayList<>();
            res.add(root.val);
            maxCnt = curCnt;
        } else if (curCnt == maxCnt) {
            res.add(root.val);
        }
        pre = root;
        traversal2(root.right);
    }

    private Map<Integer, Integer> timesMap = new HashMap<>();

    //该方法很普通，需要多次遍历
    // 1.遍历二叉树，并统计每个数出现的频率
    //2.找到最大评率
    //3.组成结果集

    public int[] findMode(TreeNode root) {
//        traversal(root);
//        int maxCnt = 0;
//        for (Map.Entry<Integer, Integer> entry : timesMap.entrySet()) {
//            if (entry.getValue() > maxCnt) {
//                maxCnt = entry.getValue();
//            }
//        }
//        ArrayList<Integer> res = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> entry : timesMap.entrySet()) {
//            if (entry.getValue() == maxCnt) {
//                res.add(entry.getKey());
//            }
//        }

        traversal2(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public void traversal(TreeNode root) {
        //递归出口
        if (root == null) {
            return;
        }
        traversal(root.left);
        timesMap.put(root.val, timesMap.getOrDefault(root.val, 0) + 1);
        traversal(root.right);
    }

    public static void main(String[] args) {
//        TreeNode root = TreeNode.buildTreeByArray(new Integer[]{1, null, 2, 2});
        TreeNode root = TreeNode.buildTreeByArray(new Integer[]{0});

        int[] res = new Solution().findMode(root);
    }
}
