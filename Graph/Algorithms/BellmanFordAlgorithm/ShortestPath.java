package Graph.Algorithms.BellmanFordAlgorithm;

import java.util.*;

public class ShortestPath {

    /**
     * Shortest Path between two Nodes using Bellman Ford Algorithm of Edge List
     * Author: Saad Ahmed
     * Date: 31 Jan, 2023
     */

//    public class Edge {
//        public int src;
//        public int dest;
//        public int weight;
//
//        public Edge(int src, int dest, int weight) {
//            this.dest = dest;
//            this.weight = weight;
//            this.src = src;
//        }
//    }


    /**
     * Complexity [findPath()] function:
     * Time Complexity:  O(E * V)
     * Space Complexity: O(V)
     */

    public static void findPath(List<Edge> graph, int src, int dest, int V) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        boolean isCycleDetected = false;

        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : graph) {
                int s = edge.src;
                int d = edge.dest;
                int w = edge.weight;

                if (s != Integer.MAX_VALUE && distance[s] + w < distance[d]) {
                    distance[d] = distance[s] + w;
                }
            }
        }

        for (Edge edge : graph) {
            int s = edge.src;
            int d = edge.dest;
            int w = edge.weight;

            if (s != Integer.MAX_VALUE && distance[s] + w < distance[d]) {
                isCycleDetected = true;
                break;
            }
        }

        if (isCycleDetected) {
            System.out.println("Negative cycle detected");
        } else {
            System.out.println(Arrays.toString(distance));
            System.out.println("Minimum distance from node " + src + " to node " + dest + " is " + distance[dest]);
        }
    }
}