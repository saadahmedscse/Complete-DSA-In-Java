package Graph.Algorithms.PrimsAlgorithm.AdjacencyMatrix;

import java.util.*;

public class MinimumSpanningTree {

    /**
     * Minimum Spanning Tree Implemented using Prim's Algorithm of Adjacency Matrix
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

    public static void solve(int[][] graph, int V) {
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

            for (int i = 0; i < V; i++) {
                if (graph[currentDest][i] != 0 && !visited[i]) {
                    pq.offer(new Pair(currentDest, i, graph[currentDest][i]));
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