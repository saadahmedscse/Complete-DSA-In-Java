package Graph.Algorithms.PrimsAlgorithm.AdjacencyList;

import java.util.*;

public class MinimumSpanningTree {

    /**
     * Minimum Spanning Tree Implemented using Prim's Algorithm of Adjacency List
     * Author: Saad Ahmed
     * Date: 31 Jan, 2023
     */

    private static class Pair {
        int src;
        int dest;
        int weight;

        public Pair(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    /**
     * Complexity [solve()] function:
     * Time Complexity:  O(V^2)
     * Space Complexity: O(V)
     */

    public static void solve(List<List<Graph.Node>> graph, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        Queue<Pair> result = new LinkedList<>();
        boolean[] visited = new boolean[V];

        pq.offer(new Pair(0, 0, 0));
        int totalMinimumWeight = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currentDest = current.dest;

            if (visited[currentDest]) continue;

            visited[currentDest] = true;
            totalMinimumWeight += current.weight;
            result.offer(current);

            for (Graph.Node neighbor : graph.get(currentDest)) {
                if (!visited[neighbor.dest]) {
                    pq.offer(new Pair(currentDest, neighbor.dest, neighbor.weight));
                }
            }
        }

        result.poll();
        System.out.println("\nSrc\t->\tDest\tWeight");
        while (!result.isEmpty()) {
            Pair p = result.poll();
            System.out.println(p.src + "\t->\t" + p.dest + "\t\t" + p.weight);
        }

        System.out.println("\nTotal cost to connect whole graph is " + totalMinimumWeight);
    }
}
