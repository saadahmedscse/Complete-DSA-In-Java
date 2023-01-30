package Graph.Traversal.AdjacencyList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {

    /**
     * Graph BFS Traversal Implementation of Adjacency List
     * Author: Saad Ahmed
     * Date: 30 Jan, 2023
     */

    /**
     * Complexity [traverse()] function:
     * Time Complexity:  O(V + E)
     * Space Complexity: O(V)
     */

    public static void traverse(List<List<Integer>> graph, int src, int V) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.offer(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            int top = q.poll();
            result.add(top);

            for (int neighbor : graph.get(top)) {
                if (!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        System.out.println(result);
    }

    /**
     * Complexity [traverseWholeGraph()] function:
     * Time Complexity:  O(V + E)
     * Space Complexity: O(V)
     */

    public static void traverseWholeGraph(List<List<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];
        List<List<Integer>> result = new ArrayList<>();
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

    private static void traverse(List<List<Integer>> graph, int src, boolean[] visited, List<List<Integer>> result) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> current = new ArrayList<>();

        q.offer(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            int top = q.poll();
            current.add(top);

            for (int neighbor : graph.get(top)) {
                if (!visited[neighbor]) {
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        result.add(current);
    }
}
