package Graph.Algorithms.KruskalsAlgorithm;

import java.util.*;

public class MinimumSpanningTree {

    /**
     * Minimum Spanning Tree Implemented using Kruskal's Algorithm of Adjacency List
     * Author: Saad Ahmed
     * Date: 01 Feb, 2023
     */

    // class Edge {
    //     public int src;
    //     public int dest;
    //     public int weight;
    
    //     public Edge(int src, int dest, int weight) {
    //         this.src = src;
    //         this.dest = dest;
    //         this.weight = weight;
    //     }
    // }

    private static int[] parent;
    private static int[] rank;

    /**
     * Complexity [solve()] function:
     * Time Complexity:  O(ELogV)
     * Space Complexity: O(E + V)
     */

    public static void solve(List<Edge> graph, int V) {
        parent = new int[V];
        rank = new int[V];

        for (int i = 0; i < V; i++) parent[i] = i;

        graph.sort(Comparator.comparingInt(o -> o.weight));
        Queue<Edge> result = new LinkedList<>();
        int totalMinimumWeight = 0;
        int count = 1;

        for (int i = 0; count < V; i++) {
            int src = graph.get(i).src;
            int dest = graph.get(i).dest;
            int weight = graph.get(i).weight;

            if (!areFriends(src, dest)) {
                union(src, dest);
                result.offer(graph.get(i));
                totalMinimumWeight += weight;
                count++;
            }
        }

        System.out.println("\nSrc\t->\tDest\tWeight");
        while (!result.isEmpty()) {
            Edge p = result.poll();
            System.out.println(p.src + "\t->\t" + p.dest + "\t\t" + p.weight);
        }

        System.out.println("\nTotal cost to connect whole graph is " + totalMinimumWeight);
    }

    private static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x == y) return;

        if (rank[x] > rank[y]) {
            parent[y] = x;
        } else if (rank[y] > rank[x]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            rank[x]++;
        }
    }

    private static boolean areFriends(int a, int b) {
        return find(parent[a]) == find(parent[b]);
    }
}