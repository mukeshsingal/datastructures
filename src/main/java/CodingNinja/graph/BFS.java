package CodingNinja.graph;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BFS {
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

        doBFS(graph, V, 0);
    }

    public static void doBFS(int[][] graph, int V, int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);

        boolean[] visited = new boolean[V];
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
