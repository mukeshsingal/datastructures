package ds.graph;

public class Vertex<T> {
    public T data;
    private boolean isVisited = false;

    Vertex(T data) {
        this.data = data;
    }
}

