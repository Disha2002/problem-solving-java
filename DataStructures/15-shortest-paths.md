# Shortest Path Algorithms

Shortest path algorithms find the minimum cost path between nodes in a graph. The two most commonly used algorithms are:

- **Dijkstra's Algorithm** (for graphs with non-negative weights)
- **Bellman-Ford Algorithm** (handles negative weights)

---

## 1. Dijkstra's Algorithm

### Characteristics

- Works with **non-negative weights**
- Uses a **priority queue** (min-heap)
- Time complexity:
  - O(V + E log V) with priority queue
- Not suitable for graphs with negative weight edges

### Java Implementation (Using PriorityQueue)

```java
import java.util.*;

class Dijkstra {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(List<List<Edge>> graph, int src) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], d = current[1];

            if (d > dist[node]) continue;

            for (Edge edge : graph.get(node)) {
                int neighbor = edge.to, weight = edge.weight;
                if (dist[neighbor] > dist[node] + weight) {
                    dist[neighbor] = dist[node] + weight;
                    pq.offer(new int[]{neighbor, dist[neighbor]});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Adding edges: u → v (weight)
        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(2, 4));
        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 7));
        graph.get(2).add(new Edge(4, 3));
        graph.get(3).add(new Edge(4, 1));

        int[] dist = dijkstra(graph, 0);
        System.out.println("Shortest distances from node 0:");
        System.out.println(Arrays.toString(dist));
    }
}
```

---

## 2. Bellman-Ford Algorithm

### Characteristics

- Works with **negative weights**
- Can detect **negative weight cycles**
- Time complexity: **O(V × E)**
- More flexible but slower than Dijkstra's

### Java Implementation

```java
import java.util.*;

class BellmanFord {
    static class Edge {
        int from, to, weight;
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static int[] bellmanFord(List<Edge> edges, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 1; i < V; i++) {
            for (Edge e : edges) {
                if (dist[e.from] != Integer.MAX_VALUE && dist[e.from] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[e.from] + e.weight;
                }
            }
        }

        // Check for negative weight cycles
        for (Edge e : edges) {
            if (dist[e.from] != Integer.MAX_VALUE && dist[e.from] + e.weight < dist[e.to]) {
                System.out.println("Graph contains a negative weight cycle");
                return null;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, 2),
            new Edge(0, 2, 4),
            new Edge(1, 2, -3),
            new Edge(1, 3, 7),
            new Edge(2, 4, 3),
            new Edge(3, 4, 1)
        );

        int[] dist = bellmanFord(edges, V, 0);
        if (dist != null) {
            System.out.println("Shortest distances from node 0:");
            System.out.println(Arrays.toString(dist));
        }
    }
}
```

---

## 3. Comparison

| Feature                | Dijkstra's       | Bellman-Ford        |
|------------------------|------------------|----------------------|
| Handles negative weights | ❌               | ✅                   |
| Detects negative cycles | ❌               | ✅                   |
| Time complexity         | O((V + E) log V) | O(V × E)            |
| Data structure used     | PriorityQueue    | Simple list         |

---

## Summary

- Use **Dijkstra** for efficiency in graphs with **non-negative weights**.
- Use **Bellman-Ford** for flexibility, especially when **negative edges** or **cycles** are possible.
- Both are foundational algorithms for solving shortest path problems in graphs.
