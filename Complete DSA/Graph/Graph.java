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

    public void bfsTraversalFullGraph() {
        boolean[] visited = new boolean[v];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                bfsTraversal(i, visited, result);
            }
        }

        System.out.println(result);
    }

    private void bfsTraversal(int source, boolean[] visited, List<Integer> result) {
        Queue<Integer> q = new LinkedList<>();

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
    }

    public void totalConnectedComponents() {
        boolean[] visited = new boolean[v];
        int components = 0;

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                components++;
                bfsTraversal(i, visited);
            }
        }

        System.out.println("Total Connected Components: " + components);
    }

    public void bfsTraversal(int source, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i = 0; i < adj.get(curr).size(); i++) {
                int neighbor = adj.get(curr).get(i);
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    public void printGraph() {
        System.out.println(adj);
    }
}