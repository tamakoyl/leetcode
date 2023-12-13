package com.tamako.graph.union_find;

import java.util.*;

/**
 * @Author:Tamako
 * @Date:2023/11/16 13:53
 * @Description: 685. 冗余连接 II  hard
 */
public class FindRedundantDirectedConnection {

    private Map<Integer, ArrayList<Integer>> neighborInVertexMap = new HashMap<>();

    private Map<Integer, ArrayList<Integer>> neighborOutVertexMap = new HashMap<>();


    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] lastAddEdge = new int[2];
        int n = edges.length;
        int cntInSameSet = 0;
        UnionAndFind unionAndFind = new UnionAndFind(n);
        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            if (unionAndFind.inSameSet(source, destination) && cntInSameSet < 1) {
                cntInSameSet++;
                lastAddEdge[0] = source;
                lastAddEdge[1] = destination;
            }
            unionAndFind.union(source, destination);
            addEdgeToGraph(source, destination);

        }
        if (exist2InDegreeVertex()) {
            for (Map.Entry<Integer, ArrayList<Integer>> entry : neighborInVertexMap.entrySet()) {
                ArrayList<Integer> inNeighborList = entry.getValue();
                Integer destVertex = entry.getKey();
                if (inNeighborList.size() == 2) {
                    //加上这条边成环
                    //成环后,需要删除顶点入度为2的其中一边
                    for (int i = inNeighborList.size() - 1; i >= 0; i--) {
                        Integer sourceVertex = inNeighborList.get(i);
                        delEdge(sourceVertex, destVertex);
                        int[] deletedEdge = new int[2];
                        deletedEdge[0] = sourceVertex;
                        deletedEdge[1] = destVertex;
                        int[][] newEdges = removeEdge(edges, deletedEdge);
                        if (isRootTree(newEdges)) {
                            return deletedEdge;
                        } else {
                            addEdgeToGraph(sourceVertex, destVertex);
                        }
                    }
                }
            }
        }
        return lastAddEdge;
    }

    public boolean exist2InDegreeVertex() {
        for (Map.Entry<Integer, ArrayList<Integer>> entry : neighborInVertexMap.entrySet()) {
            ArrayList<Integer> inNeighborList = entry.getValue();
            if (inNeighborList.size() == 2) {
                return true;
            }
        }
        return false;
    }

    public void addEdgeToGraph(int source, int destination) {
        //邻接链表与度数
        neighborOutVertexMap.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        neighborInVertexMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);

    }

    public int[][] removeEdge(int[][] edges, int[] deletedEdge) {
        return Arrays.stream(edges)
                .filter(edge -> !(edge[0] == deletedEdge[0] && edge[1] == deletedEdge[1]))
                .toArray(int[][]::new);
    }

    public void delEdge(int source, int destination) {
        neighborOutVertexMap.get(source).remove((Integer) destination);
        neighborInVertexMap.get(destination).remove((Integer) (source));
    }

    /**
     * 根树
     *
     * @return
     */
    public boolean isRootTree(int[][] edges) {
        int n = edges.length + 1;
        UnionAndFind unionAndFind = new UnionAndFind(n);
        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            if (unionAndFind.inSameSet(source, destination)) {
                return false;
            }
            unionAndFind.union(source, destination);
        }
        return unionAndFind.getConnectedComponentNum() == 1 ? true : false;
    }

    public static void main(String[] args) {
//        int[][] edges = {{2, 1}, {3, 1}, {4, 2}, {1, 4}};
//        int[][] edges = {{4,2},{1,5},{5,2},{5,3},{2,4}};
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
//        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        FindRedundantDirectedConnection findRedundantDirectedConnection = new FindRedundantDirectedConnection();
        int[] res = findRedundantDirectedConnection.findRedundantDirectedConnection(edges);
        System.out.println(res);
    }
}
