package CodingNinja.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_Disconnected {
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
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                doBFS(graph, V, i, visited);
            }
        }
    }

    public static void doBFS(int[][] graph, int V, int startVertex, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        visited[startVertex] = true;

        while (queue.size() != 0) {
            int node = queue.poll();
            System.out.print(node + " ");

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
