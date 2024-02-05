package com.tamako.binary_tree.build.from_inorder_pre_order;

import com.tamako.utils.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author:Tamako
 * @Date:2024/2/5 14:29
 * @Description:105. 从前序与中序遍历序列构造二叉树
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        List<Integer> preorderList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return traversal(preorderList, inorderList);
    }

    public TreeNode traversal(List<Integer> preorder, List<Integer> inorder) {
        //递归出口
        if (preorder.size() == 0) {
            return null;
        }
        //分割点
        Integer rootVal = preorder.get(0);
        TreeNode root = new TreeNode(rootVal);
        int splitPoint = inorder.indexOf(rootVal);
        //分割中序数组
        List<Integer> leftInorder = inorder.subList(0, splitPoint);
        List<Integer> rightInorder = inorder.subList(splitPoint + 1, inorder.size());
        //分隔前序数组
        //剔除第一个根元素
        List<Integer> pre = preorder.subList(1, preorder.size());
        List<Integer> leftPreorder = pre.subList(0, leftInorder.size());
        List<Integer> rightPreorder = pre.subList(leftInorder.size(), pre.size());
        //递归处理
        root.left = traversal(leftPreorder, leftInorder);
        root.right = traversal(rightPreorder, rightInorder);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = new Solution().buildTree(preorder, inorder);
    }
}
