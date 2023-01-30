package Graph.Implementation.DirectedGraph.AdjacencyList;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    /**
     * Directed Graph Implementation using Adjacency List
     * Author: Saad Ahmed
     * Date: 30 Jan, 2023
     */

    private final List<List<Integer>> graph;

    public Graph(int V) {
        graph = new ArrayList<>();

        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
    }

    public void addEdge(int src, int dest) {
        graph.get(src).add(dest);
    }

    public List<List<Integer>> getGraph() {
        return graph;
    }

    public String toString() {
        return graph.toString();
    }
}