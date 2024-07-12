package com.tamako.graph.dfs.all_path;

/**
 * @Author:Tamako
 * @Date:2024/3/16 07:59
 * @Description:797. 所有可能的路径
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> res = new ArrayList<>();//结果集
    private List<Integer> path = new ArrayList<>();//当前的path

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(0,graph);
        return res;
    }


    void dfs(int cur,int[][] graph){
        //递归出口
        if(graph.length - 1 == cur){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < graph[cur].length; i++){
            //处理节点
            path.add(graph[cur][i]);
            dfs(graph[cur][i],graph);
            path.remove(path.size() - 1);//回溯
        }
    }

}
