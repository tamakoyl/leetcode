package com.tamako.graph.dfs.theory;

/**
 * @Author:Tamako
 * @Date:2024/3/16 08:58
 * @Description:dfs
 */

/**
 * vector<vector<int>> result; // 保存符合条件的所有路径
 * vector<int> path; // 起点到终点的路径
 * void dfs (图，目前搜索的节点)
 *
 * void dfs(参数) {
 *     if (终止条件) {
 *         存放结果;
 *         return;
 *     }
 *
 *     for (选择：本节点所连接的其他节点) {
 *         处理节点;
 *         dfs(图，选择的节点); // 递归
 *         回溯，撤销处理结果
 *     }
 * }
 */

public class Solution {
}
