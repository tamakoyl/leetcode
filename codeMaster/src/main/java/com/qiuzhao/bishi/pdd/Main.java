import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int maxScore;
    static int[] values;
    static ArrayList<Edge>[] tree;
    static int sumEdges;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            values = new int[n + 1];
            tree = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                values[i] = scanner.nextInt();
                tree[i] = new ArrayList<>();
            }

            sumEdges = 0;

            for (int i = 0; i < n - 1; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int w = scanner.nextInt();
                tree[a].add(new Edge(b, w));
                tree[b].add(new Edge(a, w));
                sumEdges += w;
            }

            maxScore = 0;
            dfs(1, -1);
            maxScore = Math.max(maxScore, sumEdges + getMaxValue(values));

            System.out.println(maxScore);
        }

        scanner.close();
    }

    static int dfs(int node, int parent) {
        int subtreeWeightSum = 0;
        int maxValueInSubtree = values[node];

        for (Edge edge : tree[node]) {
            if (edge.to != parent) {
                int childWeightSum = dfs(edge.to, node);

                int childMaxValue = values[edge.to];

                int currentScore = sumEdges - childWeightSum + Math.max(childMaxValue, values[node]);
                maxScore = Math.max(maxScore, currentScore);

                subtreeWeightSum += childWeightSum + edge.weight;
                maxValueInSubtree = Math.max(maxValueInSubtree, childMaxValue);
            }
        }

        return subtreeWeightSum;
    }

    static int getMaxValue(int[] values) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
            }
        }
        return maxValue;
    }
}
