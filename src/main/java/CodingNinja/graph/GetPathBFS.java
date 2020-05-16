package CodingNinja.Graph;


import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class GetPathBFS {


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
        ArrayList<Integer> result = getPath(graph, V, sourceVertex, destVertex);
        if (result != null) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
    }

    public static ArrayList<Integer> getPath(int[][] graph, int V, int sourceVertex, int destVertex) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceVertex);

        boolean[] visited = new boolean[V];
        visited[sourceVertex] = true;

        if (sourceVertex == destVertex) {
            return result;
        }

        boolean flag = false;

        while (queue.size() != 0) {
            int node = queue.poll();

            for (int i = 0; i < V; i++) {
                if (node == i)
                    continue;
                if (graph[node][i] == 1 && !visited[i]) {
                    map.put(i, node);
                    queue.add(i);
                    visited[i] = true;
                    if (i == destVertex) {
                        flag = true;
                        break;
                    }
                }
            }

            if (flag)
                break;
        }

        if (flag) {
            int i = destVertex;
            result.add(destVertex);
            while (i != sourceVertex) {
                result.add(map.get(i));
                i = map.get(i);
            }
        }
        return result;
    }
}