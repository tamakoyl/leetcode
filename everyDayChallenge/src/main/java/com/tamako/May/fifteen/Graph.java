package com.tamako.May.fifteen;

public class Graph {
    private int vertexSize;
    private int [] vertex;
    private int[][] matrix;

    public Graph(int vertexSize, int[][] matrix) {
        int[] v = new int[vertexSize];
        for (int i = 1; i <= vertexSize; i++) {
            v[i] = i;
        }
        this.vertex = v;
        this.vertexSize = vertexSize;
        this.matrix = matrix;
    }

    public int getVertexSize() {
        return vertexSize;
    }

    public void setVertexSize(int vertexSize) {
        this.vertexSize = vertexSize;
    }

    public int[] getVertex() {
        return vertex;
    }

    public void setVertex(int[] vertex) {
        this.vertex = vertex;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
