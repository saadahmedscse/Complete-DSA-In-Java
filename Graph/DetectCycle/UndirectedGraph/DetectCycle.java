package Graph.DetectCycle.UndirectedGraph;

import java.util.*;

public class DetectCycle {

    /**
     * Graph DFS Traversal to detect Cycle
     * Author: Saad Ahmed
     * Date: 30 Jan, 2023
     */

    /**
     * Complexity [detectCycle()] function:
     * Time Complexity:  O(V + E)
     * Space Complexity: O(V)
     */

    public static boolean detectCycle(List<List<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(graph, -1, i, visited)) return true;
            }
        }

        return false;
    }

    private static boolean dfs(List<List<Integer>> graph, int parent, int src, boolean[] visited) {
        visited[src] = true;

        for (int neighbor : graph.get(src)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                if (dfs(graph, src, neighbor, visited)) return true;
            } else {
                if (neighbor != parent) return true;
            }
        }

        return false;
    }
}