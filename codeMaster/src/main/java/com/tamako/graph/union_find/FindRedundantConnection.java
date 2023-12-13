package com.tamako.graph.union_find;

/**
 * @Author:Tamako
 * @Date:2023/11/16 13:38
 * @Description: 684. 冗余连接
 */
public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionAndFind unionAndFind = new UnionAndFind(n);
        for (int[] edge : edges) {
            if(unionAndFind.inSameSet(edge[0] - 1,edge[1] - 1)){
                return edge;
            }
            unionAndFind.union(edge[0] - 1 ,edge[1] - 1);
        }
        return null;
    }

    public static void main(String[] args) {
        int [][] edges = {{1,2},{1,3},{2,3}};
        FindRedundantConnection findRedundantConnection = new FindRedundantConnection();
        findRedundantConnection.findRedundantConnection(edges);
    }
}
