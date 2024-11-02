package com.qiuzhao.bishi.xhs;

/**
 * @Author:Tamako
 * @Date:2024/9/1 14:48
 * @Description:TODO
 */
import java.io.*;
import java.util.*;

public class RedBlackTree {

    static List<Integer>[] tree;
    static char[] colors;
    static int[] subtreeRedCount;
    static int[] subtreeBlackCount;
    static int n;
    static int edgesToRemove = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        colors = sc.next().toCharArray();

        tree = new ArrayList[n + 1];
        subtreeRedCount = new int[n + 1];
        subtreeBlackCount = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(1, -1);

        System.out.println(edgesToRemove);

        sc.close();
    }

    private static void dfs(int node, int parent) {
        if (colors[node - 1] == 'R') {
            subtreeRedCount[node] = 1;
        } else {
            subtreeBlackCount[node] = 1;
        }

        for (int child : tree[node]) {
            if (child == parent) continue;
            dfs(child, node);

            // Check if a valid split is needed
            if (subtreeRedCount[child] > 0 && subtreeBlackCount[child] > 0) {
                edgesToRemove++;
            } else {
                // Propagate the counts upwards
                subtreeRedCount[node] += subtreeRedCount[child];
                subtreeBlackCount[node] += subtreeBlackCount[child];
            }
        }
    }
}

