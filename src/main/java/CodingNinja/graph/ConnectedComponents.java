package CodingNinja.Graph;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ConnectedComponents {

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

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> result = doDFS(graph, V, i, visited, new ArrayList<>());
                Collections.sort(result);
                if (result != null) {
                    for (int j : result) {
                        System.out.print(j + " ");
                    }
                    System.out.println("");
                }
            }
        }
    }

    public static ArrayList<Integer> doDFS(int[][] graph, int V, int s, boolean[] visited, ArrayList<Integer> result) {
        if (visited[s]) {
            return null;
        }

        visited[s] = true;

        for (int i = 0; i < V; i++) {
            if (i == s)
                continue;
            if (graph[s][i] == 1 && !visited[i]) {
                doDFS(graph, V, i, visited, result);
            }

        }

        result.add(s);
        return result;
    }
}