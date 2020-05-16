package CodingNinja.Graph2;


import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Arrays;

public class KruskalAlgorithm {
    static int V;
    static int E;

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        Edge(int a, int b, int c) {
            this.src = a;
            this.dest = b;
            this.weight = c;
        }

        public int compareTo(Edge a) {
            return Integer.compare(this.weight, a.weight);
        }
    }


    public static void main(String[] args) {
        ArrayList<Edge> edges = initGraph();
        Collections.sort(edges);

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        ArrayList<Edge> mst = new ArrayList<>();
        prepareMst(edges, mst, parent);

        print(mst);
    }

    public static void prepareMst(ArrayList<Edge> edges, ArrayList<Edge> mst, int[] parent) {
        int mstEdgeCount = 0;
        int index = 0;

        while (mstEdgeCount != V - 1) {
            Edge e = edges.get(index);

            //check if this is making a cycle
            int x = find(parent, e.src);
            int y = find(parent, e.dest);

            if (x == y) {
                index++;
                continue;
            }

            union(parent, x, y);
            mst.add(e);
            mstEdgeCount++;
        }
    }

    public static ArrayList<Edge> initGraph() {
        Scanner s = new Scanner(System.in);
        V = s.nextInt();
        E = s.nextInt();

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            int src = s.nextInt();
            int dest = s.nextInt();
            int weight = s.nextInt();
            edges.add(new Edge(src, dest, weight));
        }
        s.close();
        return edges;
    }

    public static void print(ArrayList<Edge> edges) {
        for (Edge e : edges) {
            String s;
            if (e.src > e.dest)
                s = e.dest + " " + e.src + " ";
            else
                s = e.src + " " + e.dest + " ";
            System.out.println(s + e.weight);
        }
    }

    public static int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }

    public static void union(int[] parent, int vertex1, int vertex2) {
        int pVertex1 = find(parent, vertex1);
        int pVertex2 = find(parent, vertex2);
        parent[pVertex1] = pVertex2;
    }
}
