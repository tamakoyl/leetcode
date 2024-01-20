package nov;

/**
 * @Author:Tamako
 * @Date:2023/11/15 17:59
 * @Description:并查集
 */
public class UnionAndFind {
    private int[] parent;
    private int connectedComponentNum;

    public UnionAndFind(int size) {
        initParent(size);
    }

    public void initParent(int size) {
        int[] parent = new int[size];
        this.connectedComponentNum = size;//初始化连通分量的个数
        this.parent = parent;
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    /**
     * 递归查找
     * @param n
     * @return
     */
    private int find(int n) {
        if (parent[n] == n) return n;
        else return find(parent[n]);
    }

    /**
     * 迭代查找
     * @param n
     * @return
     */
    private int find2(int n){
       while (parent[n] != n){
           n = parent[n];
       }
       return n;
    }

    /**
     * 路径压缩 + 递归
     * @param n
     * @return
     */
    private int find3(int n) {
        if (parent[n] == n) return n;
        else return parent[n] = find(parent[n]);
    }

    /**
     * 路径压缩 + 迭代
     * @param n
     * @return
     */
    private int find4(int n){
       while (parent[n] != n){
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
}

/**
 * 765. 情侣牵手
 */
class Solution11 {
    public int minSwapsCouples(int[] row) {
        //有n对情侣
        int n = row.length / 2;
        UnionAndFind unionAndFind = new UnionAndFind(n);

        for (int i = 0; i < row.length; i += 2) {
            unionAndFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return n - unionAndFind.getConnectedComponentNum();
    }
}
