public class Main {
    public static void main(String[] args) {
        int vertices = 8;
        Graph graph = new Graph(vertices);

        // 2-------4        5-------6
        //      /  |          \   /
        //    /    |           \ /
        // 3-------0            7
        //   \   /
        //    \/
        //    1

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 0);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 1);
        graph.addEdge(3, 0);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 0);
        graph.addEdge(4, 3);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.addEdge(6, 5);
        graph.addEdge(7, 5);
        graph.addEdge(7, 6);

        //graph.printGraph();                       // [[1, 3, 4], [0, 3], [4], [1, 0, 4], [2, 0, 3], [6, 7], [7, 5], [5, 6]]
        //graph.bfsTraversal(0);                    // [0, 1, 3, 4, 2]
        //graph.shortestPath(2, 1);                 // Shortest Path: 3
        //graph.bfsTraversalFullGraph();            // [0, 1, 3, 4, 2, 5, 6, 7]
        //graph.totalConnectedComponents();         // Total Connected Components: 2
    }
}
