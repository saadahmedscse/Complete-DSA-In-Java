package DisjointSet;

public class UnionFind {

    /**
     * Implementation of Disjoint Set
     * Author: Saad Ahmed
     * Date: 1 Feb, 2023
     */

    private final int[] p;
    private final int[] rank;

    public UnionFind(int n) {
        p = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) p[i] = i;
    }

    /**
     * Complexity [find()] function:
     * Time Complexity:  O(M * LogN)
     * Space Complexity: O(N)
     */

    public int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    /**
     * Complexity [union()] function:
     * Time Complexity:  O(M * LogN)
     * Space Complexity: O(N)
     */

    public void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x == y) return;

        if (rank[x] > rank[y]) {
            p[y] = x;
        } else if (rank[y] > rank[x]) {
            p[x] = y;
        } else {
            p[y] = x;
            rank[x]++;
        }
    }

    /**
     * Complexity [isFriend()] function:
     * Time Complexity:  O(M * LogN)
     * Space Complexity: O(N)
     */

    public boolean isFriend(int a, int b) {
        return find(p[a]) == find(p[b]);
    }
}