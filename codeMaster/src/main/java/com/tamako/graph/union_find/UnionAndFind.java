package com.tamako.graph.union_find;

/**
 * @Author:Tamako
 * @Date:2023/11/16 12:36
 * @Description:并查集
 */
public class UnionAndFind {
    private int[] parent;
    private int connectedComponentNum;

    public UnionAndFind(int size) {
        initParent(size);
    }

    public void initParent(int size) {
        int[] parent = new int[size + 1];
        this.connectedComponentNum = size;//初始化连通分量的个数
        this.parent = parent;
        for (int i = 1; i <= size; i++) {
            parent[i] = i;
        }
    }

    /**
     * 递归查找
     *
     * @param n
     * @return
     */
    private int find(int n) {
        if (parent[n] == n) return n;
        else return find(parent[n]);
    }

    /**
     * 迭代查找
     *
     * @param n
     * @return
     */
    private int find2(int n) {
        while (parent[n] != n) {
            n = parent[n];
        }
        return n;
    }

    /**
     * 路径压缩 + 递归
     *
     * @param n
     * @return
     */
    private int find3(int n) {
        if (parent[n] == n) return n;
        else return parent[n] = find(parent[n]);
    }

    /**
     * 路径压缩 + 迭代
     *
     * @param n
     * @return
     */
    private int find4(int n) {
        while (parent[n] != n) {
            parent[n] = parent[parent[n]];
            n = parent[n];
        }
        return n;
    }

    public int getConnectedComponentNum() {
        return connectedComponentNum;
    }

    public void union(int u, int v) {
        int parentU = find(u);
        int parentV = find(v);
        if (parentU == parentV) return;
        parent[parentU] = parentV;
        connectedComponentNum--;
    }

    public boolean inSameSet(int u, int v) {
        return find(u) == find(v);
    }
}

