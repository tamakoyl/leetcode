package com.tamako.binary_tree.bst.lowest_common_ancester;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/2/10 11:48
 * @Description:235. 二叉搜索树的最近公共祖先
 */
public class Solution {
    // todo
    // 利用二叉搜索树的特征
    //pq的公共最近公共祖先，在[p,q]中
    //从上往下遍历，第一个cur在[p,q]区间，就是最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归出口
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    /*迭代的方法*/
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
