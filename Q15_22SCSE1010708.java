import java.util.ArrayList;
import java.util.List;

public class Q15_22SCSE1010708 {
    public static List<int[]> primMST(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] key = new int[n];
        for (int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        key[0] = 0;

        for (int i = 0; i < n; i++) {
            int u = minKey(key, visited);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        List<int[]> mst = new ArrayList<>();
        for (int v = 1; v < n; v++) {
            mst.add(new int[]{parent[v], v});
        }

        return mst;
    }

    public static int minKey(int[] key, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < key.length; i++) {
            if (!visited[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        List<int[]> minimumSpanningTree = primMST(graph);
        System.out.println("Minimum Spanning Tree (edges): ");
        for (int[] edge : minimumSpanningTree) {
            System.out.println(edge[0] + " - " + edge[1]);
        }
    }
}
