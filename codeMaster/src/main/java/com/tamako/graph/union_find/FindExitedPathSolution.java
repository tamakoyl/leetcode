package com.tamako.graph.union_find;

/**
 * @Author:Tamako
 * @Date:2023/11/16 12:35
 * @Description: 1971. 寻找图中是否存在路径

 */
public class FindExitedPathSolution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionAndFind unionAndFind = new UnionAndFind(n);
        for (int[] edge : edges) {
            unionAndFind.union(edge[0],edge[1]);
        }
        return unionAndFind.inSameSet(source,destination);
    }


}



