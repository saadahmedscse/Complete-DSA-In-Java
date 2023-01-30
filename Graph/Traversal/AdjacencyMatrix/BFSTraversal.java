package Graph.Traversal.AdjacencyMatrix;

import java.util.*;

public class BFSTraversal {

    /**
     * Graph BFS Traversal Implementation of Adjacency Matrix
     * Author: Saad Ahmed
     * Date: 30 Jan, 2023
     */

    /**
     * Complexity [traverse()] function:
     * Time Complexity:  O(V^2)
     * Space Complexity: O(V)
     */

    public static void traverse(int[][] graph, int src, int V) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];

        q.offer(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            int top = q.poll();
            result.add(top);

            for (int i = 0; i < V; i++) {
                int neighbor = graph[top][i];

                if (neighbor == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }

        System.out.println(result);
    }

    /**
     * Complexity [traverseWholeGraph()] function:
     * Time Complexity:  O(V^2)
     * Space Complexity: O(V)
     */

    public static void traverseWholeGraph(int[][] graph, int V) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        int totalComponents = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                totalComponents++;
                traverse(graph, i, visited, result);
            }
        }

        System.out.println(result);
        System.out.println("Total Components: " + totalComponents);
    }

    private static void traverse(int[][] graph, int src, boolean[] visited, List<List<Integer>> result) {
        List<Integer> current = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        q.offer(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            int top = q.poll();
            current.add(top);

            for (int i = 0; i < graph[top].length; i++) {
                int neighbor = graph[top][i];

                if (neighbor == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }

        result.add(current);
    }
}