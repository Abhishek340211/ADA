import java.util.Arrays;

public class Q11_22SCSE1010708 {
    private static final int INF = Integer.MAX_VALUE;

    private static final int V = 5;

    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, -1, 0, 0, 0},
                {4, 0, 8, 0, 0},
                {0, 2, 0, 1, 3},
                {0, 0, 5, 0, -2},
                {0, 0, 0, 6, 0}
        };

        int src = 0;
        bellmanFord(graph, src);
    }

    private static void bellmanFord(int graph[][], int src) {
        int dist[] = new int[V];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }

        printSolution(dist);
    }

    private static void printSolution(int dist[]) {
        System.out.println("Vertex  Distance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + "  " + dist[i]);
        }
    }
}
