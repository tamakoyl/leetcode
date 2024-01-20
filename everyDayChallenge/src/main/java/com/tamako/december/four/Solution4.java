package com.tamako.december.four;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2023/12/4 09:12
 * @Description: 1038. 从二叉搜索树到更大和树
 */
public class Solution4 {
    private int sum = 0;

    //中序遍历累计和 [RNL]
    public TreeNode bstToGst(TreeNode root) {
        rnl(root);
        return root;
    }


    public void rnl(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        rnl(treeNode.getRight());
        sum += treeNode.getVal();
        treeNode.setVal(sum);
        rnl(treeNode.getLeft());
    }
}
