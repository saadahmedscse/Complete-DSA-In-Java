package Graph.Algorithms.KahnsAlgorithm;

import java.util.*;

public class TopologicalSort {

    /**
     * Topological Sort using Kahn's Algorithm
     * Author: Saad Ahmed
     * Date: 30 Jan, 2023
     */

    /**
     * Complexity [sort()] function:
     * Time Complexity:  O(V + E)
     * Space Complexity: O(V)
     */

    public static void sort(List<List<Integer>> graph, int V) {
        int[] inDegree = new int[V];
        for (List<Integer> edge : graph) {
            for (int vertex : edge) {
                inDegree[vertex]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int top = q.poll();
            result.add(top);

            for (int neighbor : graph.get(top)) {
                if (--inDegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        System.out.println(result);
    }
}