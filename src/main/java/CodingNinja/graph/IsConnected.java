package CodingNinja.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsConnected {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int[][] graph = new int[V][V];

        for (int i = 0; i < E; i++) {
            int startVertex = s.nextInt();
            int endVertex = s.nextInt();
            graph[startVertex][endVertex] = 1;
            graph[endVertex][startVertex] = 1;
        }

        BFSUtil(graph, V);
    }

    public static void BFSUtil(int[][] graph, int V) {
        boolean[] visited = new boolean[V];
        boolean allVisited = true;
        doBFS(graph, V, 0, visited);
        for (int i = 0; i < V; i++) {
            allVisited = allVisited && visited[i];
        }
        System.out.println(allVisited);
    }

    public static void doBFS(int[][] graph, int V, int startVertex, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        visited[startVertex] = true;

        while (queue.size() != 0) {
            int node = queue.poll();

            for (int i = 0; i < V; i++) {
                if (node == i)
                    continue;
                if (graph[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}