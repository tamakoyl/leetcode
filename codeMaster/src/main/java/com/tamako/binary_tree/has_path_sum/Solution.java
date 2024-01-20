package com.tamako.binary_tree.has_path_sum;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/1/17 20:52
 * @Description:112. 路径总和
 */
public class Solution {
    private int sum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        //递归出口
        if (root == null) return false;

        //到达叶子结点
        if (root.left == null && root.right == null) {
            sum += root.val;
            if (sum == targetSum) {
                return true;
            } else {
                sum -= root.val;
                return false;
            }
        }
        sum += root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTreeByArray(new Integer[]{1,-2,-3,1,3,-2,null,-1});
        new Solution().hasPathSum(root, 22);
    }
}
