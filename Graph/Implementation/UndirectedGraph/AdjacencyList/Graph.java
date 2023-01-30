package Graph.Implementation.UndirectedGraph.AdjacencyList;

import java.util.List;

import java.util.ArrayList;

public class Graph {

    /**
     * Undirected Graph Implementation using Adjacency List
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
        graph.get(dest).add(src);
    }

    public List<List<Integer>> getGraph() {
        return graph;
    }

    public String toString() {
        return graph.toString();
    }
}
