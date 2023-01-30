package Graph.TopologicalSort;

import java.util.*;

public class TopologicalSort {

    /**
     * Graph Topological Sort function implemented using DFS Traversal
     * Author: Saad Ahmed
     * Date: 30 Jan, 2023
     */

    /**
     * Complexity [sort()] function:
     * Time Complexity:  O(V + E)
     * Space Complexity: O(V)
     */

    public static void sort(List<List<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, stack);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (stack.size() > 1) {
            sb.append(stack.pop());
            sb.append(", ");
        }

        sb.append(stack.pop());
        sb.append("]");

        System.out.println(sb);
    }

    private static void dfs(List<List<Integer>> graph, int src, boolean[] visited, Stack<Integer> stack) {
        visited[src] = true;

        for (int neighbor : graph.get(src)) {
            if (!visited[neighbor]) dfs(graph, neighbor, visited, stack);
        }

        stack.push(src);
    }
}