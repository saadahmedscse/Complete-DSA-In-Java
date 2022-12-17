import java.util.*;

public class Graph {
    private final int v;
    private final ArrayList<ArrayList<Integer>> adj;

    public Graph(int v) {
        this.v = v;
        this.adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int s, int d) {
        adj.get(s).add(d);
    }
}