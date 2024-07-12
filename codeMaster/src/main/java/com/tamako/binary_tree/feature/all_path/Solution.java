package com.tamako.binary_tree.feature.all_path;

import com.tamako.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/1/4 16:19
 * @Description:257. 二叉树的所有路径
 */
//todo 回顾一下回溯，已经基本忘记了！！！！回溯和递归是一起的
// 还有就是 需要使用path 来存放已经访问过的结点
public class Solution {
    private List<Integer> path = new ArrayList<>();
    private List<String> res = new ArrayList<>();


    //前序遍历
    public List<String> binaryTreePaths(TreeNode root) {
        //递归出口
        path(root);
        return res;
    }

    public void path(TreeNode root) {
        //递归出口
        if (root == null) {
            return;
        }
        path.add(root.val);
        //加入路径
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            path(root.left);
            //回溯
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path(root.right);
            //回溯
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTreeByArray(new Integer[]{1, 2, 3, null, 5});
        List<String> res = new Solution().binaryTreePaths(root);

    }

}
