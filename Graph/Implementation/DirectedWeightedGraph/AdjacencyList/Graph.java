package Graph.Implementation.DirectedWeightedGraph.AdjacencyList;

import java.util.*;

public class Graph {

    /**
     * Directed Weighted Graph Implementation using Adjacency List
     * Author: Saad Ahmed
     * Date: 31 Jan, 2023
     */

    private static class Node {
        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    private final List<List<Node>> graph;
    private final int V;

    public Graph(int V) {
        graph = new ArrayList<>();
        this.V = V;

        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
    }

    public void addEdge(int src, int dest, int weight) {
        graph.get(src).add(new Node(dest, weight));
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            if (graph.get(i).size() > 0) {
                System.out.println("From node " + i + ":");

                for (Node neighbor : graph.get(i)) {
                    System.out.println("\twe can go to node " + neighbor.dest + " with weight " + neighbor.weight);
                }

                System.out.println();
            }
        }
    }
}