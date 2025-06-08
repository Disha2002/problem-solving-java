# Minimum Spanning Tree (MST)

A **Minimum Spanning Tree (MST)** of a weighted, connected, undirected graph is a subset of edges that connects all vertices without any cycles and with the minimum possible total edge weight.

---

## 1. Key Properties

- Spans all vertices (connected)
- No cycles (acyclic)
- Minimum total edge weight
- MST is not necessarily unique

---

## 2. Applications

- Network design (telecom, computer networks)
- Approximation algorithms (e.g., traveling salesman)
- Clustering algorithms

---

## 3. Algorithms to Find MST

### 3.1 Kruskal's Algorithm

**Idea:**  
Sort all edges by weight and add edges one by one, skipping those that form a cycle, until all vertices are connected.

**Data Structure:**  
Uses **Disjoint Set Union (Union-Find)** to detect cycles efficiently.

---

### Kruskal’s Algorithm Steps:

1. Sort edges by increasing weight.
2. Initialize each vertex as a separate set.
3. Iterate over edges:
   - If adding the edge does not create a cycle (vertices are in different sets), add it to MST.
4. Stop when MST has `V-1` edges.

---

### Java Implementation of Kruskal's Algorithm

```java
import java.util.*;

class KruskalMST {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int u) {
            if (parent[u] != u) parent[u] = find(parent[u]);
            return parent[u];
        }

        boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) return false;

            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootV] < rank[rootU]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            return true;
        }
    }

    public static List<Edge> kruskal(int V, List<Edge> edges) {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(V);

        List<Edge> mst = new ArrayList<>();
        for (Edge edge : edges) {
            if (uf.union(edge.src, edge.dest)) {
                mst.add(edge);
                if (mst.size() == V - 1) break;
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, 10),
            new Edge(0, 2, 6),
            new Edge(0, 3, 5),
            new Edge(1, 3, 15),
            new Edge(2, 3, 4)
        );

        List<Edge> mst = kruskal(V, edges);
        System.out.println("Edges in MST:");
        for (Edge e : mst) {
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);
        }
    }
}
```

---

### 3.2 Prim's Algorithm

**Idea:**  
Start with a vertex and grow the MST by adding the smallest edge that connects a vertex in the MST to a vertex outside it.

**Data Structure:**  
Uses a **priority queue** to pick the minimum weight edge at each step.

---

### Prim’s Algorithm Steps:

1. Initialize a priority queue and a visited set.
2. Pick an arbitrary start vertex.
3. While not all vertices are included:
   - Extract the minimum weight edge connecting MST to a new vertex.
   - Add the new vertex to MST and enqueue its edges.
4. Continue until MST spans all vertices.

---

### Java Implementation of Prim's Algorithm

```java
import java.util.*;

class PrimMST {
    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public static int prim(List<List<Edge>> graph, int start) {
        int V = graph.size();
        boolean[] visited = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        int mstWeight = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.to;
            if (visited[node]) continue;

            visited[node] = true;
            mstWeight += edge.weight;

            for (Edge adj : graph.get(node)) {
                if (!visited[adj.to]) {
                    pq.offer(adj);
                }
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Undirected graph edges
        graph.get(0).add(new Edge(1, 2));
        graph.get(1).add(new Edge(0, 2));

        graph.get(0).add(new Edge(3, 6));
        graph.get(3).add(new Edge(0, 6));

        graph.get(1).add(new Edge(2, 3));
        graph.get(2).add(new Edge(1, 3));

        graph.get(1).add(new Edge(3, 8));
        graph.get(3).add(new Edge(1, 8));

        graph.get(1).add(new Edge(4, 5));
        graph.get(4).add(new Edge(1, 5));

        graph.get(2).add(new Edge(4, 7));
        graph.get(4).add(new Edge(2, 7));

        int mstWeight = prim(graph, 0);
        System.out.println("Total weight of MST (Prim's): " + mstWeight);
    }
}
```

---

## 4. Comparison of Kruskal and Prim

| Feature           | Kruskal's Algorithm               | Prim's Algorithm               |
|-------------------|---------------------------------|-------------------------------|
| Approach          | Edge-based (global sorting)      | Vertex-based (growing tree)   |
| Data Structure    | Union-Find                      | Priority Queue                |
| Suitable For      | Sparse graphs                    | Dense graphs                  |
| Complexity        | O(E log E)                      | O(E log V)                   |
| Starts From       | No specific start vertex needed  | Requires a start vertex       |

---

## Summary

- MST connects all vertices with the minimum total edge weight.
- **Kruskal's** uses edge sorting and union-find to avoid cycles.
- **Prim's** grows the MST from a starting vertex using a priority queue.
- Both algorithms produce valid MSTs but differ in approach and performance characteristics.
