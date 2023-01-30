package Graph.Traversal.AdjacencyMatrix;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {

    /**
     * Graph DFS Traversal Implementation of Adjacency Matrix
     * Author: Saad Ahmed
     * Date: 30 Jan, 2023
     */

    /**
     * Complexity [traverse()] function:
     * Time Complexity:  O(V^2)
     * Space Complexity: O(V)
     */

    public static void traverse(List<List<Integer>> graph, int src, int V) {
        List<Integer> result = new ArrayList<>();
        dfs(graph, src, new boolean[V], result);

        System.out.println(result);
    }

    private static void dfs(List<List<Integer>> graph, int src, boolean[] visited, List<Integer> result) {
        result.add(src);
        visited[src] = true;

        for (int neighbor : graph.get(src)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited, result);
            }
        }
    }

    /**
     * Complexity [traverseWholeGraph()] function:
     * Time Complexity:  O(V^2)
     * Space Complexity: O(V)
     */

    public static void traverseWholeGraph(List<List<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];
        List<List<Integer>> result = new ArrayList<>();
        int totalComponents = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                totalComponents++;
                result.add(dfsWhole(graph, i, visited, new ArrayList<>()));
            }
        }

        System.out.println(result);
        System.out.println("Total Components: " + totalComponents);
    }

    private static List<Integer> dfsWhole(List<List<Integer>> graph, int src, boolean[] visited, List<Integer> current) {
        current.add(src);
        visited[src] = true;

        for (int neighbor : graph.get(src)) {
            if (!visited[neighbor]) {
                dfsWhole(graph, neighbor, visited, current);
            }
        }

        return current;
    }
}