package Graph.DetectCycle.DirectedGraph;

import java.util.*;

public class DetectCycle {

    /**
     * DFS Traversal to detect Cycle in a Directed Graph
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
        boolean[] recursionStack = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                if (dfs(graph, i, visited, recursionStack)) return true;
            }
        }

        return false;
    }

    private static boolean dfs(List<List<Integer>> graph, int src, boolean[] visited, boolean[] recursionStack) {
        visited[src] = true;
        recursionStack[src] = true;

        for (int neighbor : graph.get(src)) {
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor, visited, recursionStack)) return true;
            } else if (recursionStack[neighbor]) return true;
        }

        recursionStack[src] = false;

        return false;
    }
}