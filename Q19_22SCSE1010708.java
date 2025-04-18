public class Q19_22SCSE1010708 {
    static final int INF = 99999;
    static void transitiveClosure(int graph[][]) {
        int V = graph.length;
        int[][] reach = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                reach[i][j] = graph[i][j];

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    reach[i][j] = (reach[i][j] != 0) ||
                            ((reach[i][k] != 0) && (reach[k][j] != 0)) ? 1 : 0;
                }
            }
        }
        System.out.println("Transitive closure matrix is:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                System.out.print(reach[i][j] + " ");
            System.out.println();
        }
    }
    static void shortestPath(int graph[][]) {
        int V = graph.length;
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF &&
                            dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        System.out.println("\nShortest path matrix is:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = { {0, 1, 1, INF},
                {INF, 0, INF, 1},
                {INF, INF, 0, INF},
                {1, INF, INF, 0}
        };
        transitiveClosure(graph);
        shortestPath(graph);
    }
}
