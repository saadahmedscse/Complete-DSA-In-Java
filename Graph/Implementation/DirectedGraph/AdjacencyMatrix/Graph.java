package Graph.Implementation.DirectedGraph.AdjacencyMatrix;

import java.util.Arrays;

public class Graph {

    /**
     * Directed Graph Implementation using Adjacency Matrix
     * Author: Saad Ahmed
     * Date: 30 Jan, 2023
     */

    private final int[][] graph;

    public Graph(int V) {
        graph = new int[V][V];
    }

    public void addEdge(int src, int dest) {
        graph[src][dest] = 1;
    }

    public int[][] getGraph() {
        return graph;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int[] i : graph) {
            sb.append(Arrays.toString(i));
            sb.append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }
}