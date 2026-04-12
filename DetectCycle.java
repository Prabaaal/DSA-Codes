import java.util.*;

public class DetectCycle {

    // ─────────────────────────────────────────
    // 1. UNDIRECTED GRAPH — DFS
    // ─────────────────────────────────────────
    static boolean hasCycleUndirected(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsUndirected(i, -1, visited, adj)) return true;
            }
        }
        return false;
    }

    static boolean dfsUndirected(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfsUndirected(neighbor, node, visited, adj)) return true;
            } else if (neighbor != parent) {
                // Visited neighbor that isn't our parent → cycle!
                return true;
            }
        }
        return false;
    }

    // ─────────────────────────────────────────
    // 2. DIRECTED GRAPH — DFS + Recursion Stack
    // ─────────────────────────────────────────
    static boolean hasCycleDirected(int V, List<List<Integer>> adj) {
        boolean[] visited  = new boolean[V];
        boolean[] recStack = new boolean[V]; // tracks current DFS path

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsDirected(i, visited, recStack, adj)) return true;
            }
        }
        return false;
    }

    static boolean dfsDirected(int node, boolean[] visited, boolean[] recStack, List<List<Integer>> adj) {
        visited[node]  = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfsDirected(neighbor, visited, recStack, adj)) return true;
            } else if (recStack[neighbor]) {
                // Neighbor is on the current path → back edge → cycle!
                return true;
            }
        }

        recStack[node] = false; // remove from current path on backtrack
        return false;
    }

    // ─────────────────────────────────────────
    // Helper — build adjacency list
    // ─────────────────────────────────────────
    static List<List<Integer>> buildGraph(int V, int[][] edges, boolean undirected) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            if (undirected) adj.get(e[1]).add(e[0]);
        }
        return adj;
    }

    // ─────────────────────────────────────────
    // Main — test both cases
    // ─────────────────────────────────────────
    public static void main(String[] args) {
        // Undirected: 0-1-2-0 forms a cycle
        int[][] undirectedEdges = {{0,1},{1,2},{2,0}};
        List<List<Integer>> undirAdj = buildGraph(3, undirectedEdges, true);
        System.out.println("Undirected cycle: " + hasCycleUndirected(3, undirAdj)); // true

        // Directed: 0→1→2→3 no cycle
        int[][] dirEdgesNoCycle = {{0,1},{1,2},{2,3}};
        List<List<Integer>> dirAdj1 = buildGraph(4, dirEdgesNoCycle, false);
        System.out.println("Directed cycle (none): " + hasCycleDirected(4, dirAdj1)); // false

        // Directed: 0→1→2→1 has cycle
        int[][] dirEdgesCycle = {{0,1},{1,2},{2,1}};
        List<List<Integer>> dirAdj2 = buildGraph(3, dirEdgesCycle, false);
        System.out.println("Directed cycle (yes):  " + hasCycleDirected(3, dirAdj2)); // true
    }
}