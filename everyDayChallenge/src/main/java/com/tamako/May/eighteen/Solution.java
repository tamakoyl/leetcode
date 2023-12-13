package com.tamako.May.eighteen;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:Tamako
 * @Date:2023/4/18 00:36
 * @Description:1026. 节点与其祖先之间的最大差值
 */
public class Solution {

    //使用dfs进行枚举：返回当前子树的最大值和最小值
    public int maxAncestorDiff(TreeNode root) {
       return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root,int max,int min){
        if(root == null){
            return 0;
        }
        int res = Math.max(Math.abs(root.val - min),Math.abs( root.val - max));
        min = Math.min(root.val, min);
        max = Math.max(root.val,max);
        //左子树最大差值
        res = Math.max(res,dfs(root.left,max,min));
        //右子树最大差值
        res = Math.max(res,dfs(root.right,max,min));
        return res;
    }


}

