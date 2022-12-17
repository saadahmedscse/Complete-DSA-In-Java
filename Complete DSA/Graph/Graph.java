import java.util.*;

public class Graph {
    private final int v;
    private final ArrayList<ArrayList<Integer>> adj;

    public Graph(int v) {
        this.v = v;
        this.adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int s, int d) {
        adj.get(s).add(d);
    }

    public void bfsTraversal(int source) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);

        q.offer(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);

            for (int i = 0; i < adj.get(curr).size(); i++) {
                int neighbor = adj.get(curr).get(i);

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }

        System.out.println(result);
    }
}