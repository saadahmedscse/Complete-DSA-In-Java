package Graph.Algorithms.DijkstrasAlgorithm;

import java.util.*;

public class ShortestPath {

    /**
     * Shortest Path between two Nodes using Dijkstra's Algorithm of Adjacency List
     * Author: Saad Ahmed
     * Date: 31 Jan, 2023
     */

    private static class Pair {
        int dest;
        int weight;

        public Pair(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    /**
     * Complexity [findPath()] function:
     * Time Complexity:  O(ELogE)
     * Space Complexity: O(E + V)
     */

    public static void findPath(List<List<Graph.Node>> graph, int src, int dest, int V) {
        int[] pathArray = new int[V];
        for (int i = 0; i < V; i++) pathArray[i] = Integer.MAX_VALUE;
        pathArray[src] = 0;

        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int source = current.dest;

            if (visited[source]) continue;
            visited[source] = true;

            for (Graph.Node neighbor : graph.get(source)) {
                if (pathArray[neighbor.dest] > pathArray[source] + neighbor.weight) {
                    pathArray[neighbor.dest] = pathArray[source] + neighbor.weight;

                    pq.offer(new Pair(neighbor.dest, pathArray[neighbor.dest]));
                }
            }
        }

        System.out.println("Minimum distance from node " + src + " to node " + dest + " is " + pathArray[dest]);
    }
}