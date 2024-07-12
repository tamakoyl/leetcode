package com.intern.interview.meituan.m_2024_4_15;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/4/15 14:02
 * @Description:TODO
 */
public class BinaryTreeMaxPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null)
            return 0;

        // 递归计算左右子树的最大贡献值
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 更新全局最大路径和
        int sum = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, sum);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        // 构建测试用例
        TreeNode root = TreeNode.buildTreeByArray(new Integer[] { 1, -2, 3, 4, 5, 6, 7 });

        // 创建 BinaryTreeMaxPathSum 实例并计算最大路径和
        BinaryTreeMaxPathSum solution = new BinaryTreeMaxPathSum();
        int maxPathSum = solution.maxPathSum(root);
        System.out.println("Max Path Sum: " + maxPathSum);
    }

}
