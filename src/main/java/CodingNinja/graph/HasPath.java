package CodingNinja.graph;

import java.util.Scanner;

public class HasPath {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();

        int[][] graph = new int[V][V];

        for(int i=0; i < E; i++) {
            int startVertex = s.nextInt();
            int endVertex = s.nextInt();
            graph[startVertex][endVertex] = 1;
            graph[endVertex][startVertex] = 1;
        }

        int sourceVertex = s.nextInt();
        int destVertex = s.nextInt();

        boolean[] visited = new boolean[V];
        hasPath(graph, V, sourceVertex, visited);

        boolean result = visited[destVertex];

        System.out.println(result);
    }

    public static void hasPath(int[][] graph, int V, int s, boolean[] visited) {
        if (visited[s]) {
            return;
        }

        visited[s] = true;
        for (int i = 0; i < V; i++) {
            if (graph[s][i] == 1 && !visited[i]) {
                hasPath(graph, V, i, visited);
            }
        }
    }
}