import java.util.*;

class Dijsktra {
    private int V;
    
    Dijsktra(int v) {
        V = v;
    }
    
    int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int i = 0; i < V; i++) {
            if (dist[i] < min && sptSet[i] == false) {
                min = dist[i];
                min_index = i;
            }
        }
        
        return min_index;
    }

    void shortestPath(int[][] mextix, int src) {
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;
        for (int i = 0; i < V-1; i++) {
            int m = minDistance(dist, sptSet);
            sptSet[m] = true;
            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[m][v] != 0
                               && dist[m] != Integer.MAX_VALUE
                               && dist[m] + graph[m][v] < dist[v]) {
                    dist[v] = dist[m] + graph[m][v];
                }
            }
        }
        printSolution(dist);
    }

    void printSolution(int[] dist) {
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                    {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                    {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                    {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                    {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                    {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                    {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                    {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                    {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                   };
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }
}	
