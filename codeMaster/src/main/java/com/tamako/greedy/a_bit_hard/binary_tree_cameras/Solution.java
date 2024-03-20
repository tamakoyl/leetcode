package com.tamako.greedy.a_bit_hard.binary_tree_cameras;

import com.tamako.utils.TreeNode;

/**
 * @Author:Tamako
 * @Date:2024/3/6 10:31
 * @Description:968. 监控二叉树
 */
public class Solution {
    //贪心策略：
    // 局部最优解: 有直接父亲和孩子的节点直接先放camera，然后标记被监控的节点 [我的想法感觉有点难实现呀！！]
    //codeMaster:所以我们要从下往上看，局部最优：让叶子节点的父节点安摄像头，所用摄像头最少，整体最优：全部摄像头数量所用最少！
    //自底向上: 后序遍历，递归返回时可以做到
    // 隔一个节点放一个camera

    //todo 本题引入了：状态转移的思想
    /**
     * 节点的状态值：
     * 0 表示无覆盖
     * 1 表示 有摄像头
     * 2 表示有覆盖
     * 后序遍历，根据左右节点的情况,来判读 自己的状态
     */
    private int cnt = 0;

    public int minCameraCover(TreeNode root) {
        if(traversal(root) == 0) {// 如果根节点无覆盖
            cnt++;// 需要增加一个camera
        }
        return cnt;
    }

    private int traversal(TreeNode root) {
        if (root == null) {// 递归出口
            return 2;// 空节点表示被覆盖
        }
        int l = traversal(root.left);// 左
        int r = traversal(root.right);// 右

        // 中
        if (l == 0 || r == 0) {// 左右孩子如有没有覆盖的
            // 父节点应该有camera
            cnt++;
            return 1;
        } else if (l == 1 || r == 1) {// 左右孩子有摄像头
            // 父节点被覆盖
            return 2;
        } else {// 左右孩子都被覆盖
            // 因为需要尽可能少的camera，父节点无覆盖
            return 0;
        }
    }

}
