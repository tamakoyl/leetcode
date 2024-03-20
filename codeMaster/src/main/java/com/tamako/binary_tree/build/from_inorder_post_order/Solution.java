package com.tamako.binary_tree.build.from_inorder_post_order;

import com.tamako.utils.TreeNode;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:Tamako
 * @Date:2024/2/1 18:44
 * @Description:106.从中序与后序遍历序列构造二叉树 todo 这个题虽然有思路 但是代码实现比较复杂
 * 区间划分，一定需要清楚开闭
 */
public class Solution {

    private HashMap<Integer, Integer> inorderPosMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderPosMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderPosMap.put(inorder[i], i);
        }
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
//        List<Integer> inorderList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
//        List<Integer> postOrderList = Arrays.stream(postorder).boxed().collect(Collectors.toList());
//        return traversal(inorderList, postOrderList);
        return build(0, inorder.length - 1, inorder, 0, postorder.length - 1, postorder);
    }

    /*基于原来的数组，通过index来构建二叉树*/
    public TreeNode build(int inorderBegin, int inorderEnd, int[] inorder, int postBegin, int postEnd, int[] postorder) {
        //todo 注意递归出口的条件
        if (inorderBegin > inorderEnd || postBegin > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        Integer splitPointer = inorderPosMap.get(rootVal);
        //分割中序数组
        //左边:[inorderBegin,splitPointer)
        //右边：(splitPointer,inorderEnd]
        //分割后序数组
        //左边:[postBegin,postBegin+(splitPointer-inorderBegin)]
        //右边:[postBegin+(splitPointer-inorderBegin),postEnd-1]
        System.out.println("=====leftInorder");
        for (int i = inorderBegin; i <= splitPointer - 1; i++) {
            System.out.println(inorder[i]);
        }
        System.out.println("=====rightInorder");
        for (int i = splitPointer + 1; i <= inorderEnd; i++) {
            System.out.println(inorder[i]);
        }
        System.out.println("=====leftPost");
        for (int i = postBegin; i <= postBegin + (splitPointer - inorderBegin) - 1; i++) {
            System.out.println(postorder[i]);
        }
        System.out.println("=====rightPost");
        for (int i = postBegin + (splitPointer - inorderBegin); i <= postEnd - 1; i++) {
            System.out.println(postorder[i]);
        }
        root.left = build(inorderBegin, splitPointer - 1, inorder, postBegin, postBegin + (splitPointer - inorderBegin) - 1, postorder);
        root.right = build(splitPointer + 1, inorderEnd, inorder, postBegin + (splitPointer - inorderBegin), postEnd - 1, postorder);
        return root;
    }

    /*这样的写法每次都会copy数组，耗时浪费空间*/
    public TreeNode traversal(List<Integer> inorder, List<Integer> postorder) {
        //递归出口
        if (postorder.size() == 0) {
            return null;
        }
        Integer rootVal = postorder.get(postorder.size() - 1);
        TreeNode root = new TreeNode(rootVal);
        //切割中序数组
        //中序数组切割点
        int rootIndex = inorder.indexOf(rootVal);
        //切割中序数组，左边[0,rootIndex)
        List<Integer> leftInorder = inorder.subList(0, rootIndex);
        //切割中序数组，右边[rootIndex+1,inorder.size()-1]
        List<Integer> rightInorder = inorder.subList(rootIndex + 1, inorder.size());
        //切割后序数组
        //切割后序数组，后序数组没有明确的切割点，用中序数组的大小来界定
        //丢弃最后一个root
        List<Integer> post = postorder.subList(0, postorder.size() - 1);
        //左边[0,leftInorder.size())
        List<Integer> leftPost = post.subList(0, leftInorder.size());
        //右边[leftInorder.size(),post.size())
        //递归处理左边和右边
        List<Integer> rightPost = post.subList(leftInorder.size(), post.size());

        //查看切割的具体情况
        System.out.println("=====leftInorder");
        for (Integer i : leftInorder) {
            System.out.println(i);
        }
        System.out.println("=====rightInorder");
        for (Integer i : rightInorder) {
            System.out.println(i);
        }
        System.out.println("=====leftPost");
        for (Integer i : leftPost) {
            System.out.println(i);
        }
        System.out.println("=====rightPost");
        for (Integer i : rightPost) {
            System.out.println(i);
        }
        root.left = traversal(leftInorder, leftPost);
        root.right = traversal(rightInorder, rightPost);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = new Solution().buildTree(inorder, postorder);
    }
}
