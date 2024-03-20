package com.tamako.binary_tree.bst.delete;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/2/10 18:07
 * @Description:450. 删除二叉搜索树中的节点
 */
public class Solution {

    //思路：
    //todo 没那么简单
    //分情况讨论：
    //1. 删除的是叶子节点 -> 直接删除就OK
    //2. 删除的是分支节点
    //(1) 该分支节点有两个子节点：选取右边的子节点来代替
    //(2) 该分支节点只有一个子节点：选取子节点来代替
    private TreeNode parent = null;

    public TreeNode deleteNode(TreeNode root, int key) {
        //递归出口
        if (root.val == key) {
            //删除的是叶子节点
            if (root.left == null && root.right == null) {
                if (parent.val > key) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                //删除的是分支节点，且其左右孩子不为空
            } else if (root.left != null && root.right != null) {
                if (parent.val > key) {
                }
            }
        }

        return null;
    }
}
