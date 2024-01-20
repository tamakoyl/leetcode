package com.tamako.binary_tree.bottom_left_element;

import com.tamako.utils.TreeNode;


/**
 * @Author:Tamako
 * @Date:2024/1/17 19:18
 * @Description:513. 找树左下角的值
 */
public class Solution {
    private int bottomLeftElement = 0;
    private int maxDepth = Integer.MIN_VALUE;

    //最后一层最左边的元素 也没有错 不过不容易实现
    //
    // todo 深度最大的叶子结点  -> 最后一层 [一开始没什么头绪呀！！]
    public int findBottomLeftValue(TreeNode root) {
        find(root,0);
        return bottomLeftElement;
    }

    //todo 需要传入depth呀
    public void find(TreeNode root, int depth) {
        //递归出口
        if (root == null) return;
        //叶子结点
        if (root.left == null && root.right == null){
            //深度变大，更新结果值
            if(maxDepth < depth) bottomLeftElement = root.val;
            maxDepth = Math.max(depth,maxDepth);
        }

        find(root.left,depth+1);//深度+1,保证先遍历左边
        find(root.right,depth+1);

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTreeByArray(new Integer[]{1, 2, 3});

    }

}
