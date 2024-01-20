package com.tamako.binary_tree.level.depth.n_node.max;

import com.tamako.utils.NNode;

import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/1/4 11:49
 * @Description:559. N 叉树的最大深度
 */
public class Solution {
    //todo 递归出口 区别开 minDepth
    public int maxDepth(NNode root) {
        //递归出口
        if(root == null ) return 0;

        int maxLen = 0;
        List<NNode> children = root.children;
        for(NNode child: children){
            maxLen = Math.max(maxDepth(child),maxLen);
        }
        return maxLen+1;
    }
}
