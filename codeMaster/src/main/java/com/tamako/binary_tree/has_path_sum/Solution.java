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
        if (root == null) return false;
        return traversal(root,targetSum - root.val);
    }


    public boolean concise(TreeNode root,int cnt){
        if(root == null)return false;
        //到达叶子结点
        if (root.left == null && root.right == null && cnt == root.val) return true;
        return hasPathSum(root.left,cnt-root.val) || hasPathSum(root.right,cnt-root.val);
    }
    public boolean traversal(TreeNode root,int cnt){
        //递归出口

        //到达叶子结点
        if (root.left == null && root.right == null && cnt == 0) return true;

        //到达叶子结点 但是值不相等的时候
        if (root.left == null && root.right == null) return false;

        //左边
        if(root.left !=null){
            cnt -= root.left.val;
            if(traversal(root.left,cnt))return true;
            //回溯
            cnt += root.left.val;
        }
        //右边
        if(root.right != null){
            cnt -= root.right.val;
            if(traversal(root.right,cnt))return true;
            //回溯
            cnt += root.right.val;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTreeByArray(new Integer[]{1,-2,-3,1,3,-2,null,-1});
        new Solution().hasPathSum(root, 3);
    }
}
