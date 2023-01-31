package Graph.Implementation.UndirectedWeightedGraph.AdjacencyMatrix;

import java.util.Arrays;

public class Graph {

    /**
     * Undirected Weighted Graph Implementation using Adjacency Matrix
     * Author: Saad Ahmed
     * Date: 31 Jan, 2023
     */

    private final int[][] graph;
    private final int V;

    public Graph(int V) {
        this.V = V;
        graph = new int[V][V];
    }

    public void addEdge(int src, int dest, int weight) {
        graph[src][dest] = weight;
        graph[dest][src] = weight;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int[] neighbors : graph) {
            sb.append(Arrays.toString(neighbors));
            sb.append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {

            boolean printedFirstLine = false;

            for (int j = 0; j < V; j++) {
                int weight = graph[i][j];

                if (weight != 0) {
                    if (!printedFirstLine) {
                        System.out.println("From node " + i + ":");
                        printedFirstLine = true;
                    }
                    System.out.println("\twe can go to node " + j + " with weight " + weight);
                }
            }
            System.out.println();
        }
    }
}