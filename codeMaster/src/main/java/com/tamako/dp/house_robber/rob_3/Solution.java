package com.tamako.dp.house_robber.rob_3;

import com.tamako.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Tamako
 * @Date:2024/3/13 10:56
 * @Description:337.打家劫舍 III
 */
public class Solution {
    //todo 树形dp啊 ！！！ dp就是长度为2的一维数组啊
    // 还有就是记忆化搜索！！
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0],res[1]);
    }


    //暴力
    //后序遍历
    public int bruteForce(TreeNode root) {
        //递归出口
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        //左
        // rob 父节点，就跳过左右孩子
        int robVal1 = root.val;
        if (root.left != null) {
            robVal1 += bruteForce(root.left.left) + bruteForce(root.left.right);
        }
        //右
        if (root.right != null) {
            robVal1 += bruteForce(root.right.left) + bruteForce(root.right.right);
        }

        //根 rob 左右孩子
        int robVal2 = bruteForce(root.right) + bruteForce(root.left);
        return Math.max(robVal2, robVal1);
    }


    //记忆化搜索
    // 可以 ac的
    private Map<TreeNode, Integer> memo = new HashMap<>();

    public int memorySearch(TreeNode root) {
        //递归出口
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        //算过直接返回
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        //左
        // rob 父节点，就跳过左右孩子
        int robVal1 = root.val;
        if (root.left != null) {
            robVal1 += memorySearch(root.left.left) + memorySearch(root.left.right);
        }
        //右
        if (root.right != null) {
            robVal1 += memorySearch(root.right.left) + memorySearch(root.right.right);
        }

        //根 rob 左右孩子
        int robVal2 = memorySearch(root.right) + memorySearch(root.left);
        memo.put(root, Math.max(robVal2, robVal1));//记录
        return Math.max(robVal2, robVal1);
    }


    //dp[0] 偷
    //dp[1] 不偷
    private int[] robTree(TreeNode root) {
        //递归出口
        if (root == null) {
            return new int[]{0, 0};
        }
        //左右
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);
        //偷当前节点
        int valRob = root.val + left[1] + right[1];
        //不偷当前节点
        int valNotRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{valRob, valNotRob};
    }


}
