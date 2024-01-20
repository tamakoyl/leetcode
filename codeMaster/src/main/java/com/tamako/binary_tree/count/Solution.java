package com.tamako.binary_tree.count;

import com.tamako.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:Tamako
 * @Date:2024/1/4 13:57
 * @Description:222. 完全二叉树的节点个数
 */
public class Solution {
    public int countNodes(TreeNode root) {
        //层次遍历的办法
        Queue<TreeNode> que = new LinkedList<>();
        if(root!=null) que.offer(root);
        int cnt = 0;
        while(!que.isEmpty()){
            TreeNode front = que.poll();
            cnt++;
            if(front.left!=null)que.offer(front.left);
            if(front.right!=null)que.offer(front.right);
        }
        return cnt;
    }

    //依靠的是递归的栈的调用
    public int count(TreeNode root){
        //递归出口
        if(root == null)return 0;
        //左
        int l = count(root.left);
        //右
        int r = count(root.right);
        return l+r+1;
    }
}
