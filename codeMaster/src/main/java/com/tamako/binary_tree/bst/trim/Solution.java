package com.tamako.binary_tree.bst.trim;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/2/10 18:14
 * @Description:669. 修剪二叉搜索树
 */
public class Solution {
    //todo 看到给的第二个案例 又被吓到了，因为重构了二叉树，刚刚那道删除节点的题还没做出来呢[因为也需要重构二叉树yaya]
    //
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //递归出口
        if(root == null){
            return null;
        }
        if(root.val < low){
            return trimBST(root.right, low, high);//让右子树替代
        }
        if(root.val > high){
            return trimBST(root.left,low,high);//让左子树代替；
        }
        root.left = trimBST(root.left,low,high);//符合条件的节点
        root.right = trimBST(root.right,low,high);
        return root;
    }
}
