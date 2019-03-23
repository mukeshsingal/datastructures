package CodingNinja.graph;

import java.util.Scanner;
import java.util.ArrayList;

public class GetPath {

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

        int sourceVertex = s.nextInt();
        int destVertex = s.nextInt();

        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = getPath(graph, V, sourceVertex, destVertex, visited, new ArrayList<>());
        if (result != null) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
    }

    public static ArrayList<Integer> getPath(int[][] graph, int V, int s, int d, boolean[] visited, ArrayList<Integer> result) {
        if (visited[s]) {
            return null;
        }

        if (s == d) {
            result.add(d);
            return result;
        }

        visited[s] = true;

        for (int i = 0; i < V; i++) {
            if (graph[s][i] == 1 && !visited[i]) {
                ArrayList<Integer> temp = getPath(graph, V, i, d, visited, result);
                if (temp != null) {
                    temp.add(s);
                    return temp;
                }
            }
        }
        return null;
    }
}
